package com.myrotiuk.auction.common.persistence.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by pav on 2/12/15.
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.myrotiuk.auction.common.persistence.repository"})
@ComponentScan(basePackages = {"com.myrotiuk.auction.common.persistence.repository"})
@PropertySource(value = {"classpath:db.properties"})
public class PersistenceConfig {

    @Value("${mongo.dbName}")
    private String dbName;

    @Value("${mongo.address}")
    private String address;


    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(address), dbName);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
