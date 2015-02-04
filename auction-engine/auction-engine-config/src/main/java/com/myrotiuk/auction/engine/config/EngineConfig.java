package com.myrotiuk.auction.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.Resource;

/**
 * Created by pav on 2/2/15.
 */
@Configuration
@EnableAspectJAutoProxy
@Resource()
@PropertySource(value = {"/WEB-INF/jms.properties"})
@ComponentScan(basePackages = {"com.myrotiuk.auction.engine.service","com.myrotiuk.auction.engine"})
public class EngineConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        System.setProperty("logFilename", "/usr/local/tomcat/apache-tomcat-8.0.17/logs/auction-engine.log");
        return new PropertySourcesPlaceholderConfigurer();
    }
}
