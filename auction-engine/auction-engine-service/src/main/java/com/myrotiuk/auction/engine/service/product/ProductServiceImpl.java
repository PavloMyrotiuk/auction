package com.myrotiuk.auction.engine.service.product;

import com.myrotiuk.auction.common.core.message.BaseMessage;
import com.myrotiuk.auction.common.core.message.BetMessage;
import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.engine.service.message.MessageProcessor;
import com.myrotiuk.auction.engine.service.message.MessageProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 2/2/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private MessageProcessorFactory processorFactory;

    @Override
    public void readNewProductCreatedMessage(ProductCreatedMessage message) {
        processMessage(message);
    }

    @Override
    public void readBetMessage(BetMessage message) {
        processMessage(message);
    }

    private void processMessage(BaseMessage message) {
        MessageProcessor messageProcessor = processorFactory.getMessageProcessor(message);
        messageProcessor.process(message);
    }
}

