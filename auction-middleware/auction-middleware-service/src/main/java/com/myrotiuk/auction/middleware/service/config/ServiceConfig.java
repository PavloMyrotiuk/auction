package com.myrotiuk.auction.middleware.service.config;

import com.myrotiuk.auction.common.persistence.config.PersistenceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by pav on 2/20/15.
 */
@Configuration
@Import({PersistenceConfig.class})
@ComponentScan(basePackages = {"com.myrotiuk.auction.middleware.service"})
public class ServiceConfig {
}
