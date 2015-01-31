package com.myrotiuk.auction.web.config;

import com.myrotiuk.auction.web.converter.Product2ProductVOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 1/30/15.
 */
@Configuration
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
        return result;
    }
}
