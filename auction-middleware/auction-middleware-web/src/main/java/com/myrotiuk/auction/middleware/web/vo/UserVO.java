package com.myrotiuk.auction.middleware.web.vo;

import java.util.Set;

import com.myrotiuk.auction.common.core.model.user.UserRole;

/**
 * Created by pav on 2/13/15.
 */
public class UserVO {

    private String userId;

    private String name;

    private String username;

    private Set<UserRole> roles;

    private Long validDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getValidDate() {
        return validDate;
    }

    public void setValidDate(Long validDate) {
        this.validDate = validDate;
    }
}
