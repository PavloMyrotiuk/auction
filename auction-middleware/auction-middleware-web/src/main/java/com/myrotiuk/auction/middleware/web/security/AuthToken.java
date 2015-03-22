package com.myrotiuk.auction.middleware.web.security;

import com.myrotiuk.auction.middleware.web.vo.UserVO;

/**
 * Created by pav on 3/22/15.
 */
public class AuthToken {

    private UserVO user;
    private Long validDate;

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public void setValidDate(Long validDate) {
        this.validDate = validDate;
    }
}
