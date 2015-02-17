package com.myrotiuk.auction.middleware.web.security.service;

import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.security.converter.User2UserDetailsConverter;
import com.myrotiuk.auction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 2/17/15.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        return conversionService.convert(user, UserDetails.class);
    }
}
