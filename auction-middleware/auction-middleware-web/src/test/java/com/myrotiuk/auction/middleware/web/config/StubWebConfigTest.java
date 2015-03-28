package com.myrotiuk.auction.middleware.web.config;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.middleware.service.product.ProductService;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by pav on 3/26/15.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.web.controller"})
public class StubWebConfigTest {

    @Bean
    public UserService userService(){
        return null;
    }

    @Bean
    public ProductService productService(){
        return null;
    }

    @Bean
    public CategoryService categoryService(){
        return null;
    }

    @Bean
    public CustomConversionService conversionService(){
        return null;
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        return null;
    }


}
