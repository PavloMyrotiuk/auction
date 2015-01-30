package com.myrotiuk.auction.service;

import com.myrotiuk.auction.model.message.ProductCreatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by pav on 1/30/15.
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void sendNewProductCreated(ProductCreatedMessage message) {

    }
}
