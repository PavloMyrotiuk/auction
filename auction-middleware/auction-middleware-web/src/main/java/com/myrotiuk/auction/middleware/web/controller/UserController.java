package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 2/13/15.
 */
@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value ="/{id}", method = RequestMethod.GET)


    @RequestMapping(value ="/{name}", method = RequestMethod.GET)
    public User persistUser(@PathVariable("name") String name){
        User u = new User();
        u.setName(name);
        userService.addUser(u);
        return u;
    }
}
