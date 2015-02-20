package com.myrotiuk.auction.middleware.service.config;

import com.myrotiuk.auction.middleware.service.converter.Product2ProductCreatedMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/20/15.
 */
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.service"})
public class ServiceConfig {

    @Bean
    public ConversionService conversionService(){
        ConversionServiceFactoryBean csfb = new ConversionServiceFactoryBean();
        csfb.setConverters(getConverters());
        csfb.afterPropertiesSet();
        return csfb.getObject();
    }

    private Set<Converter> getConverters(){
        Set<Converter> result = new HashSet<>();
        result.add(new Product2ProductCreatedMessageConverter());
        return result;
    }
}
