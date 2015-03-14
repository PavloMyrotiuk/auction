package com.myrotiuk.auction.engine.service.product;

import com.myrotiuk.auction.common.core.message.BetMessage;
import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 2/2/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    @JmsListener(containerFactory = "messageListenerContainerFactory", destination = "${jms.queue.CreatedProductQueue}" )
    public void readNewProductCreatedMessage(ProductCreatedMessage message) {
        System.out.println(message);
    }

    @Override
    @JmsListener(containerFactory = "messageListenerContainerFactory", destination = "${jms.queue.BetQueue}" )
    public void readBetMessage(BetMessage betMessage) {
        System.out.println(betMessage);
    }
}

