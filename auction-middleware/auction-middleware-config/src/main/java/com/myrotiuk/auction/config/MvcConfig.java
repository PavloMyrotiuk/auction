package com.myrotiuk.auction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pav on 1/24/15.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.web.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter {
}
