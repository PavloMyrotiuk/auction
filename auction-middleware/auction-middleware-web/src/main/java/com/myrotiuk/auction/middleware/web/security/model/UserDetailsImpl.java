package com.myrotiuk.auction.middleware.web.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/17/15.
 */
public class UserDetailsImpl implements UserDetails {

    private String username;

    private String password;

    private Set<String> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (roles == null) return Collections.emptySet();
        Set<GrantedAuthority> result = new HashSet<>();
        for (String role : roles) {
            result.add(new SimpleGrantedAuthority(role));
        }

        return result;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
