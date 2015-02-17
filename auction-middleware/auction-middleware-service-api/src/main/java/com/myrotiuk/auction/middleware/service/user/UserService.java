package com.myrotiuk.auction.middleware.service.user;

import com.myrotiuk.auction.model.user.User;

/**
 * Created by pav on 2/13/15.
 */
public interface UserService {

    User create(User entity);

    User getUserByUserName(String userName);
}
