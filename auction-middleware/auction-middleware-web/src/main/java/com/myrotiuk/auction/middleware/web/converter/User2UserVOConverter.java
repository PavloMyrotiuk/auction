package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.UserVO;
import com.myrotiuk.auction.model.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 2/21/15.
 */
@Component
public class User2UserVOConverter implements Converter<User, UserVO> {

    @Override
    public UserVO convert(User source) {
        UserVO userVO = new UserVO();
        userVO.setName(source.getName());
        userVO.setRoles(source.getRoles());
        userVO.setUsername(source.getUsername());
        return userVO;
    }
}
