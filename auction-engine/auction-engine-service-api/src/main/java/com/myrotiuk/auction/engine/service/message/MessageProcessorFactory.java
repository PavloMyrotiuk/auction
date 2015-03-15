package com.myrotiuk.auction.engine.service.message;

import com.myrotiuk.auction.common.core.message.BaseMessage;

/**
 * Created by pav on 3/15/15.
 */
public interface MessageProcessorFactory {
    MessageProcessor getMessageProcessor(BaseMessage message);
}
