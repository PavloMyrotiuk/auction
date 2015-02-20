package com.myrotiuk.auction.middleware.service.user;

import com.myrotiuk.auction.middleware.service.BaseEntityService;
import com.myrotiuk.auction.model.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by pav on 2/13/15.
 */
public interface UserService extends BaseEntityService<User>, UserDetailsService {
}
