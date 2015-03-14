package com.myrotiuk.auction.middleware.config;

import com.myrotiuk.auction.common.jms.config.JmsConfig;
import com.myrotiuk.auction.common.logging.config.LoggingAspectConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
@Import({JmsConfig.class, LoggingAspectConfig.class})
@PropertySource(value = {"classpath:jms.properties"})
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.service","com.myrotiuk.auction.middleware"})
public class MiddlewareConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
