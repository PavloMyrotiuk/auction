package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 2/13/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User entity){
        return userService.create(entity);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public long get(@PathVariable("id") long id){
//        return 3;
//    }

}
