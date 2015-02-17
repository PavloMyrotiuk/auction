package com.myrotiuk.auction.middleware.web.security.converter;

import com.myrotiuk.auction.middleware.web.security.model.UserDetailsImpl;
import com.myrotiuk.auction.model.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by pav on 2/17/15.
 */
public class User2UserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User source) {
        UserDetails result = new UserDetailsImpl();
        BeanUtils.copyProperties(source, result, UserDetailsImpl.class);
        return result;
    }
}
