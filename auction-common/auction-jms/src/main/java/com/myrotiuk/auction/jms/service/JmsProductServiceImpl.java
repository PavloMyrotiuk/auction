package com.myrotiuk.auction.jms.service;

import com.myrotiuk.auction.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.model.message.ProductCreatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 1/30/15.
 */
@Service
public class JmsProductServiceImpl implements JmsProductService {

    @Autowired
    @CreatedProductTemplate
    private JmsTemplate jmsTemplate;

    @Override
    public void sendNewProductCreatedMessage(ProductCreatedMessage message) {
        jmsTemplate.convertAndSend(message);
    }

    @Override
    @JmsListener(containerFactory = "messageListenerContainerFactory", destination = "${jms.queue.CreatedProductQueue}")
    public void readNewProductCreatedMessage(ProductCreatedMessage message) {
        System.out.println(message);
    }
}
