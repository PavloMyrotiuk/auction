package com.myrotiuk.auction.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
public class JmsConfig {

    @Value("${jms.broker.url}")
    private String brokerUrl;

    public ActiveMQConnectionFactory connectionFactory(){
ActiveMQConnectionFactory result = new ActiveMQConnectionFactory();
        result.setBrokerURL(brokerUrl);
        return result;
    }
}
