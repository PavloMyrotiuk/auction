package com.myrotiuk.auction.middleware.service.user;

import com.myrotiuk.auction.common.persistence.repository.UserRepository;
import com.myrotiuk.auction.middleware.service.BaseEntityServiceImpl;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.common.core.model.user.UserRole;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/13/15.
 */
@Service
public class UserServiceImpl extends BaseEntityServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    protected MongoRepository<User, ObjectId> getRepository() {
        return userRepository;
    }

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
