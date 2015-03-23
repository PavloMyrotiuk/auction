package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.vo.BetVO;
import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(value = PowerMockRunner.class)
@PrepareForTest(SecurityContextHolder.class)
public class BetVO2BetConverterTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private static BetVO2BetConverter converter;

    @BeforeClass
    public static void init() {
        converter = new BetVO2BetConverter();
    }

    @Test
    public void testConvertValidBetVOShouldReturnValidBet() {
        ObjectId id = ObjectId.get();
        String username = "username";
        BetVO vo = new BetVO();
        vo.setAmount(new BigDecimal(333));
        vo.setProductId(id.toString());

        User user = new User();

        mockStatic(SecurityContextHolder.class);
        Authentication authentication = mock(Authentication.class);
        SecurityContext context = mock(SecurityContext.class);
        when(SecurityContextHolder.getContext()).thenReturn(context);
        when(context.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(username);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        when(userService.loadUserByUsername(captor.capture())).thenReturn(user);

        Bet bet = converter.convert(vo);
        assertEquals(vo.getAmount(), bet.getAmount());
        assertEquals(user, bet.getUser());
        assertEquals("username", captor.getValue());
        verify(userService, times(1)).loadUserByUsername(anyString());
    }

    @Test
    public void testConvertNullShouldReturnNull() {
        Bet result = converter.convert(null);
        assertThat(result, is(nullValue()));
    }
}