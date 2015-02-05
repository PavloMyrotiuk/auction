package com.myrotiuk.auction.engine.config;

import com.myrotiuk.auction.message.ProductCreatedMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pav on 1/25/15.
 */
@EnableJms
@Configuration
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
    public MappingJackson2MessageConverter getJacksonMessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdMappings(getTypeIdMappings());
        return mappingJackson2MessageConverter;
    }

    private Map<String, Class<?>> getTypeIdMappings(){
        Map<String, Class<?>> result = new HashMap<>();
        result.put("productCreatedMessage", ProductCreatedMessage.class);
        return result;
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

    @Bean
    public DefaultJmsListenerContainerFactory messageListenerContainerFactory(){
        DefaultJmsListenerContainerFactory result = new DefaultJmsListenerContainerFactory();
        result.setConnectionFactory(cachingConnectionFactory());
        result.setMessageConverter(getJacksonMessageConverter());
        return result;
    }

}
