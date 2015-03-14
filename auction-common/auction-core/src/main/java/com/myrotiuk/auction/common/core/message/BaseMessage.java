package com.myrotiuk.auction.common.core.message;

/**
 * Created by pav on 3/14/15.
 */
public abstract class BaseMessage {

    private MessageType messageType;


    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
