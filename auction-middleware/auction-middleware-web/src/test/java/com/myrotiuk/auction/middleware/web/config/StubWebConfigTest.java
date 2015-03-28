package com.myrotiuk.auction.middleware.web.config;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.middleware.service.product.ProductService;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionServiceFactoryBean;
import com.myrotiuk.auction.middleware.web.security.config.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by pav on 3/26/15.
 */
@EnableWebMvc
@Configuration
@Import({SecurityConfig.class})
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.web.controller"
                               ,"com.myrotiuk.auction.middleware.web.converter"
                               , "com.myrotiuk.auction.middleware.web.converter.service"})
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
    public ConversionService conversionService() {
        return customConversionServiceFactoryBean().getObject();
    }

    @Bean
    public CustomConversionServiceFactoryBean customConversionServiceFactoryBean(){
        return new CustomConversionServiceFactoryBean();
    }


}
