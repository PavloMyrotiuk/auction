package com.myrotiuk.auction.engine.service.product;

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

}

