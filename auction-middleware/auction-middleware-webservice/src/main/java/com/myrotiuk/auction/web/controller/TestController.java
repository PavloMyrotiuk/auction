package com.myrotiuk.auction.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 1/25/15.
 */
@RestController
@RequestMapping("/rest")
public class TestController {

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String test(){
        return "Hello";
    }
}
