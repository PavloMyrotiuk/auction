package com.myrotiuk.auction.middleware.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.common.core.model.user.UserRole;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.config.StubWebConfigTest;
import junit.framework.Assert;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {StubWebConfigTest.class})
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testPostUserToUserControllerShouldReturnValidJson() throws Exception {
        User req = new User();
        req.setName("John");
        req.setUsername("John@myrotiuk.com");
        req.setPassword("a");

        User expected = new User();
        expected.setName("John");
        expected.setPassword("a");
        expected.setUsername("John@myrotiuk.com");
        expected.setRoles(new HashSet<UserRole>() {{
            this.add(UserRole.ROLE_USER);
        }});
        expected.setId(ObjectId.get());

        ObjectMapper mapper = new ObjectMapper();
        String reqJsonUser = mapper.writeValueAsString(req);

        when(userService.create((User)anyObject())).thenReturn(expected);

        MvcResult mvcResult  =mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(reqJsonUser))
                .andExpect(status().isOk())
                .andReturn();
        String mvcResultUser = mvcResult.getResponse().getContentAsString();

        assertEquals( mapper.writeValueAsString(expected), mvcResultUser);
    }
}