package com.myrotiuk.auction.middleware.web.security.utils;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by pav on 2/17/15.
 */
public class TokenUtils {

    /*one hour*/
    public static final long TOKEN_EXPIRATION_TIME = 1000L * 60 * 60;

    public static String createToken(UserDetails userDetails){

        long expires = System.currentTimeMillis() + TOKEN_EXPIRATION_TIME;

        StringBuilder tokenBuilder = new StringBuilder();
        tokenBuilder.append(userDetails.getUsername());
        tokenBuilder.append(":");
        tokenBuilder.append(expires);

        return tokenBuilder.toString();
    }
}
