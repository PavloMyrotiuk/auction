package com.myrotiuk.auction.middleware.service.user;

import com.myrotiuk.auction.middleware.persistence.repository.UserRepository;
import com.myrotiuk.auction.model.user.User;
import com.myrotiuk.auction.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/13/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User create(User entity) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.ROLE_USER);
        entity.setRoles(roles);
        return userRepository.save(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
