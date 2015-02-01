package com.myrotiuk.auction.jms.service;

import com.myrotiuk.auction.model.message.ProductCreatedMessage;

/**
 * Created by pav on 1/30/15.
 */
public interface JmsProductService {

    void sendNewProductCreatedMessage(ProductCreatedMessage message);

    void readNewProductCreatedMessage(ProductCreatedMessage message);
}
