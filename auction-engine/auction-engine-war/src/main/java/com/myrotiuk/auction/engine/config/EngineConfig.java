package com.myrotiuk.auction.engine.config;

import com.myrotiuk.auction.common.jms.config.JmsConfig;
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
@Import({JmsConfig.class})
@PropertySource(value = {"/WEB-INF/jms.properties"})
@ComponentScan(basePackages = {"com.myrotiuk.auction.engine.service","com.myrotiuk.auction.engine"})
public class EngineConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
