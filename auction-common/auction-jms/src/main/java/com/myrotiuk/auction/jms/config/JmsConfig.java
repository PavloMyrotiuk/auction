package com.myrotiuk.auction.jms.config;

import com.myrotiuk.auction.jms.annotation.CreatedProductTemplate;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.jms.annotation", "com.myrotiuk.auction.jms.service"})
public class JmsConfig {

    @Value("${jms.broker.url}")
    private String brokerUrl;

    @Value("${jms.queue.CreatedProductQueue}")
    private String createdProductQueue;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory result = new ActiveMQConnectionFactory();
        result.setBrokerURL(brokerUrl);
        return result;
    }

    @Bean
    @CreatedProductTemplate
    public JmsTemplate jmsTemplate() {
        JmsTemplate result = new JmsTemplate();
        result.setConnectionFactory(cachingConnectionFactory());
        result.setDefaultDestination(createdProductQueue());
        MessageConverter messageConverter = getJacksonMessageConverter();
        result.setMessageConverter(messageConverter);
        return result;
    }

    private MappingJackson2MessageConverter getJacksonMessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        return mappingJackson2MessageConverter;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(){
        CachingConnectionFactory result = new CachingConnectionFactory();
        result.setTargetConnectionFactory(connectionFactory());
        return result;
    }

    @Bean
    public ActiveMQQueue createdProductQueue(){
        return new ActiveMQQueue(createdProductQueue);
    }
}
