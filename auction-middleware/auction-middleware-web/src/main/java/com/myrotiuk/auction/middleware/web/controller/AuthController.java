package com.myrotiuk.auction.middleware.web.controller;

import javax.ws.rs.FormParam;

import com.myrotiuk.auction.middleware.web.security.utils.TokenUtils;
import com.myrotiuk.auction.middleware.web.security.model.SecurityToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 2/17/15.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Authenticates a user and creates an authentication token.
     *
     * @param username
     *            The name of the user.
     * @param password
     *            The password of the user.
     * @return Authentication token.
     */
    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public SecurityToken authenticate(@FormParam("username") String username, @FormParam("password") String password) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(username);
        return new SecurityToken(TokenUtils.createToken(userDetails));

    }
}
