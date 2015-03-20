package com.myrotiuk.auction.common.jms.config;

import com.myrotiuk.auction.common.jms.annotation.BetQueueTemplate;
import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.Destination;

/**
 * Created by pav on 1/25/15.
 */
@EnableJms
@Configuration
@ComponentScan(basePackages = {"com.myrotiuk.auction.common.jms.annotation","com.myrotiuk.auction.common.jms"})
@PropertySource(value = {"classpath:jms.properties"})
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
        return getJmsTemplate(createdProductQueue());
    }

    @Bean
    @BetQueueTemplate
    public JmsTemplate betQueueTemplate() {
        return getJmsTemplate(betQueue());
    }

    private JmsTemplate getJmsTemplate(Destination destination) {
        JmsTemplate result = new JmsTemplate();
        result.setConnectionFactory(connectionFactory());
        result.setDefaultDestination(destination);
        result.setMessageConverter(mappingJacksonMessageConverter());
        result.setSessionTransacted(true);
        return result;
    }

    @Bean
    public MappingJackson2MessageConverter mappingJacksonMessageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("type");
        return mappingJackson2MessageConverter;
    }

    @Bean
    public ActiveMQQueue createdProductQueue() {
        return new ActiveMQQueue(createdProductQueue);
    }

    @Bean
    public ActiveMQQueue betQueue() {
        return new ActiveMQQueue(betQueue);
    }
}
