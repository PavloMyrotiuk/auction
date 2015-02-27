package com.myrotiuk.auction.middleware.web.config;

import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionServiceFactoryBean;
import com.myrotiuk.auction.middleware.web.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Created by pav on 1/30/15.
 */
@EnableWebMvc
@Configuration
@Import({SecurityConfig.class})
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.web.controller"
        , "com.myrotiuk.auction.middleware.web.security"
        , "com.myrotiuk.auction.middleware.web"})
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    public CustomConversionServiceFactoryBean customConversionServiceFactoryBean(){
        return new CustomConversionServiceFactoryBean();
    }

    @Bean
    public CustomConversionService conversionService() {
        return (CustomConversionService)customConversionServiceFactoryBean().getObject();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
        handlerAdapter.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return handlerAdapter;
    }
}
