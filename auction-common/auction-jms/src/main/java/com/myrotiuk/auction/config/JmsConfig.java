package com.myrotiuk.auction.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
public class JmsConfig {

    @Value("${jms.broker.url}")
    private String brokerUrl;



    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory result = new ActiveMQConnectionFactory();
        result.setBrokerURL(brokerUrl);
        return result;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate result = new JmsTemplate();
        result.setConnectionFactory(connectionFactory());
        return result;
    }
}
