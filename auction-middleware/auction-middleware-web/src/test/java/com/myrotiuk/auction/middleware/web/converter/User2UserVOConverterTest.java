package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.UserVO;
import com.myrotiuk.auction.model.user.User;
import com.myrotiuk.auction.model.user.UserRole;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class User2UserVOConverterTest {

    private static User2UserVOConverter user2UserVOConverter;

    @BeforeClass
    public static void initConverter() {
        user2UserVOConverter = new User2UserVOConverter();
    }

    @Test
    public void testConvert() throws Exception {
        User user = new User();

        ObjectId id = ObjectId.get();
        user.setId(id);
        user.setName("name");
        user.setRoles(new HashSet<UserRole>() {{
            this.add(UserRole.ROLE_USER);
        }});
        user.setUsername("username");

        UserVO userVO = user2UserVOConverter.convert(user);
        assertEquals(id.toString(), userVO.getUserId());
        assertEquals(user.getName(), userVO.getName());
        assertEquals(user.getUsername(), userVO.getUsername());
        assertTrue(userVO.getRoles().contains(UserRole.ROLE_USER));
    }
}