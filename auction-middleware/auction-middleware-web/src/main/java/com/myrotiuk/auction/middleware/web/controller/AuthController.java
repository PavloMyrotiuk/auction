package com.myrotiuk.auction.middleware.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomConversionService conversionService;

    /**
     * Authenticates a user and creates an authentication token.
     *
     * @param username The name of the user.
     * @param password The password of the user.
     * @return Authentication token.
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @PreAuthorize("permitAll")
    public UserVO authenticate(@FormParam("username") String username, @FormParam("password") String password, HttpServletRequest request) {

        int sessionValid = request.getSession().getMaxInactiveInterval(); //seconds
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userService.loadUserByUsername(username);
        UserVO result = conversionService.convert(userDetails, UserVO.class);
        result.setValidDate(System.currentTimeMillis() + sessionValid * 1000);
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @PreAuthorize("permitAll")
    public void logout(HttpServletRequest request) throws ServletException {
        request.logout();
    }
}
