package com.myrotiuk.auction.common.jms.config;

import com.myrotiuk.auction.common.jms.annotation.BetQueueTemplate;
import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pav on 1/25/15.
 */
@EnableJms
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.common.jms.annotation","com.myrotiuk.auction.common.jms"})
public class JmsConfig {

    @Value("${jms.broker.url}")
    private String brokerUrl;

    @Value("${jms.queue.CreatedProductQueue}")
    private String createdProductQueue;

    @Value("${jms.queue.BetQueue}")
    private String betQueue;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory result = new ActiveMQConnectionFactory();
        result.setBrokerURL(brokerUrl);
        return result;
    }

    @Bean
    @CreatedProductTemplate
    public JmsTemplate createProductTemplate() {
        JmsTemplate result = new JmsTemplate();
        result.setConnectionFactory(cachingConnectionFactory());
        result.setDefaultDestination(createdProductQueue());
        result.setMessageConverter(getJacksonMessageConverter());
        return result;
    }

    @Bean
    @BetQueueTemplate
    public JmsTemplate betQueueTemplate() {
        JmsTemplate result = new JmsTemplate();
        result.setConnectionFactory(cachingConnectionFactory());
        result.setDefaultDestination(betQueue());
        result.setMessageConverter(getJacksonMessageConverter());
        return result;
    }

    @Bean
    public MappingJackson2MessageConverter getJacksonMessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdMappings(getTypeIdMappings());
        mappingJackson2MessageConverter.setTypeIdPropertyName("type");
        return mappingJackson2MessageConverter;
    }

    private Map<String, Class<?>> getTypeIdMappings(){
        Map<String, Class<?>> result = new HashMap<>();
        result.put("ProductCreatedMessage", ProductCreatedMessage.class);
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
    public ActiveMQQueue betQueue(){
        return new ActiveMQQueue(betQueue);
    }

    @Bean
    public DefaultJmsListenerContainerFactory messageListenerContainerFactory(){
        DefaultJmsListenerContainerFactory result = new DefaultJmsListenerContainerFactory();
        result.setConnectionFactory(cachingConnectionFactory());
        result.setMessageConverter(getJacksonMessageConverter());
        return result;
    }

}
