package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.UserVO;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.common.core.model.user.UserRole;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class User2UserVOConverterTest {

    private static User2UserVOConverter converter;

    @BeforeClass
    public static void init() {
        converter = new User2UserVOConverter();
    }

    @Test
    public void testConvertValidUserShouldReturnPopulatedValidVO() throws Exception {
        User user = new User();

        ObjectId id = ObjectId.get();
        user.setId(id);
        user.setName("name");
        user.setRoles(new HashSet<UserRole>() {{
            this.add(UserRole.ROLE_USER);
        }});
        user.setUsername("username");

        UserVO userVO = converter.convert(user);
        assertEquals(id.toString(), userVO.getUserId());
        assertEquals(user.getName(), userVO.getName());
        assertEquals(user.getUsername(), userVO.getUsername());
        assertTrue(userVO.getRoles().contains(UserRole.ROLE_USER));
    }

    @Test
    public void testConvertNullUserShouldReturnNull() {
    User user = null;

        UserVO  userVO= converter.convert(user);
        assertThat(userVO, is(nullValue()));
    }
}