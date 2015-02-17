package com.myrotiuk.auction.middleware.web.security.model;

/**
 * Created by pav on 2/17/15.
 */
public class SecurityToken {

    private final String token;

    public SecurityToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
