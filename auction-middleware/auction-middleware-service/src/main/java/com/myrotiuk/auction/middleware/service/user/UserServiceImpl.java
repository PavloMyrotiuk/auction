package com.myrotiuk.auction.middleware.service.user;

import com.myrotiuk.auction.middleware.persistence.repository.UserRepository;
import com.myrotiuk.auction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 2/13/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void addUser(User entity) {
        userRepository.save(entity);
    }
}
