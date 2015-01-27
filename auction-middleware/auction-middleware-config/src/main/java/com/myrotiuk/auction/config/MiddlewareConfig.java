package com.myrotiuk.auction.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource(value = {"/WEB-INF/jms.properties"})
@ComponentScan(basePackages = {"com.myrotiuk.auction"})
public class MiddlewareConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
