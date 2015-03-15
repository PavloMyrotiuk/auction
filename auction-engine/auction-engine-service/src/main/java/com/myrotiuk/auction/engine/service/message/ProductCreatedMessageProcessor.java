package com.myrotiuk.auction.engine.service.message;

import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.engine.service.annotation.ProductCreatedMessageProcessorQualifier;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/15/15.
 */
@Component
@ProductCreatedMessageProcessorQualifier
public class ProductCreatedMessageProcessor implements MessageProcessor<ProductCreatedMessage> {

    @Override
    public void process(ProductCreatedMessage message) {
//should be quarz job created;
    }
}
