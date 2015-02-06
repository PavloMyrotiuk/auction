package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.message.ProductCreatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 2/2/15.
 */
@Service
public class JmsProductServiceImpl implements JmsProductService{

    @Autowired
    @CreatedProductTemplate
    private JmsTemplate jmsTemplate;

    public void sendNewProductCreatedMessage(ProductCreatedMessage message) {
        jmsTemplate.convertAndSend(message);
    }
}
