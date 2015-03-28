package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.common.core.model.user.UserRole;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.config.StubWebConfigTest;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.UserVO;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(PowerMockRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {StubWebConfigTest.class})
@PrepareForTest({SecurityContextHolder.class})
public class AuthControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserService userService;

    @Mock
    private CustomConversionService conversionService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    public void testAuthenticateUserShouldReturnAuthToken() throws Exception {
        User expected = new User();
        expected.setName("John");
        expected.setPassword("a");
        expected.setUsername("John@myrotiuk.com");
        expected.setRoles(new HashSet<UserRole>() {{
            this.add(UserRole.ROLE_USER);
        }});
        expected.setId(ObjectId.get());

        UserVO userVO = new UserVO();
        userVO.setName("John");
        userVO.setUsername("John@myrotiuk.com");
        userVO.setRoles(new HashSet<UserRole>() {{
            this.add(UserRole.ROLE_USER);
        }});
        userVO.setUserId(ObjectId.get().toString());


        Authentication authentication = mock(Authentication.class);
        mockStatic(SecurityContextHolder.class);
        SecurityContext context = mock(SecurityContext.class);

        ArgumentCaptor<UsernamePasswordAuthenticationToken> authenticationTokenArgumentCaptor =
                ArgumentCaptor.forClass(UsernamePasswordAuthenticationToken.class);

        when(userService.loadUserByUsername("John@myrotiuk.com")).thenReturn(expected);
        when(authenticationManager.authenticate(authenticationTokenArgumentCaptor.capture())).thenReturn(authentication);
        when(conversionService.convert(expected, UserVO.class)).thenReturn(userVO);
        when(SecurityContextHolder.getContext()).thenReturn(context);

        mockMvc.perform(post("/auth/authenticate?username=John@myrotiuk.com&&password=a"))
                .andExpect(status().isOk());

        assertEquals("John@myrotiuk.com", authenticationTokenArgumentCaptor.getValue().getPrincipal());
        assertEquals("a", authenticationTokenArgumentCaptor.getValue().getCredentials());
        verify(context, times(1)).setAuthentication(authentication);
        verify(userService, times(1)).loadUserByUsername("John@myrotiuk.com");
        verify(conversionService, times(1)).convert(expected, UserVO.class);
    }

}