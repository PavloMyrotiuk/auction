package com.myrotiuk.auction.middleware.web.config;

import com.myrotiuk.auction.middleware.web.converter.Product2ProductVOConverter;
import com.myrotiuk.auction.middleware.web.converter.User2UserVOConverter;
import com.myrotiuk.auction.middleware.web.security.config.SecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

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
public class WebConfig extends WebMvcConfigurationSupport {
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
        result.add(new User2UserVOConverter());
        return result;
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
        handlerAdapter.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return handlerAdapter;
    }
}
