package com.myrotiuk.auction.engine.config;

import com.myrotiuk.auction.common.jms.config.JmsConfig;
import com.myrotiuk.auction.common.logging.config.LoggingAspectConfig;
import com.myrotiuk.auction.common.persistence.config.PersistenceConfig;
import com.myrotiuk.auction.engine.service.product.ProductService;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.jms.Destination;
import javax.jms.Session;

/**
 * Created by pav on 1/25/15.
 */
@Configuration
@Import({JmsConfig.class, LoggingAspectConfig.class, PersistenceConfig.class})
@ComponentScan(basePackages = {"com.myrotiuk.auction.engine.service.annotation",
        "com.myrotiuk.auction.engine.service.message",
        "com.myrotiuk.auction.engine.service.product",
        "com.myrotiuk.auction.engine"})
public class EngineConfig {

    @Autowired
    private JmsConfig jmsConfig;

    @Autowired
    private ProductService productService;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DefaultMessageListenerContainer createdProductQueueListenerContainer() {
        return getMessageListenerContainer(jmsConfig.createdProductQueue(), productService, "readNewProductCreatedMessage");
    }

    @Bean
    public DefaultMessageListenerContainer betProductQueueListenerContainer() {
        return getMessageListenerContainer(jmsConfig.betQueue(), productService, "readBetMessage");
    }

    private DefaultMessageListenerContainer getMessageListenerContainer(Destination destination, Object delegate, String method) {
        DefaultMessageListenerContainer dmlc = new DefaultMessageListenerContainer();
        dmlc.setConnectionFactory(jmsConfig.connectionFactory());
        dmlc.setDestination(destination);
        dmlc.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        MessageListenerAdapter listener = new MessageListenerAdapter();
        listener.setDelegate(delegate);
        listener.setDefaultListenerMethod(method);
        listener.setMessageConverter(jmsConfig.mappingJacksonMessageConverter());
        dmlc.setMessageListener(listener);
        return dmlc;
    }

    @Bean
    public SchedulerFactory schedulerFactory() {
        return new StdSchedulerFactory();
    }


}
