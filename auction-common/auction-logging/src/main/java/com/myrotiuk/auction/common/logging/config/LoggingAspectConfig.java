package com.myrotiuk.auction.common.logging.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by pav on 2/4/15.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.myrotiuk.auction.common.logging.aspect", "com.myrotiuk.auction.logging"})
public class LoggingAspectConfig {
}
