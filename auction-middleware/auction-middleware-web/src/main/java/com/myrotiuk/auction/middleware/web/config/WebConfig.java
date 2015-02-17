package com.myrotiuk.auction.middleware.web.config;

import com.myrotiuk.auction.middleware.web.converter.Product2ProductVOConverter;
import com.myrotiuk.auction.middleware.web.security.config.SecurityConfig;
import com.myrotiuk.auction.middleware.web.security.converter.User2UserDetailsConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 1/30/15.
 */
@EnableWebMvc
@Configuration
@Import({SecurityConfig.class})
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.web.controller"
                              ,"com.myrotiuk.auction.middleware.web.security"
                              ,"com.myrotiuk.auction.middleware.web"})
public class WebConfig {
    @Bean
    public ConversionService conversionService(){
        ConversionServiceFactoryBean csfb = new ConversionServiceFactoryBean();
        csfb.setConverters(getConverters());
        csfb.afterPropertiesSet();
        return csfb.getObject();
    }

    private Set<Converter> getConverters(){
        Set<Converter> result = new HashSet<>();
        result.add(new Product2ProductVOConverter());
        result.add(new User2UserDetailsConverter());
        return result;
    }
}
