package com.myrotiuk.auction.engine.service.message;

import com.myrotiuk.auction.common.core.message.BaseMessage;
import com.myrotiuk.auction.engine.service.annotation.BetMessageProcessorQualifier;
import com.myrotiuk.auction.engine.service.annotation.ProductCreatedMessageProcessorQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/15/15.
 */
@Component
public class MessageProcessorFactoryImpl implements MessageProcessorFactory{

    @Autowired
    @BetMessageProcessorQualifier
    private MessageProcessor betMessageProcessor;

    @Autowired
    @ProductCreatedMessageProcessorQualifier
    private MessageProcessor createdProductMessageProcessor;

    public MessageProcessor getMessageProcessor(BaseMessage message){

        switch (message.getMessageType()){
            case BET: return betMessageProcessor;
            case PRODUCT_CREATED: return createdProductMessageProcessor;
        }
        throw new IllegalArgumentException("Wrong message type.");
    }

}
