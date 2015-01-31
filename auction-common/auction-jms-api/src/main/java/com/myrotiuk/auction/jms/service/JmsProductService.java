package com.myrotiuk.auction.jms.service;

import com.myrotiuk.auction.model.message.ProductCreatedMessage;

/**
 * Created by pav on 1/30/15.
 */
public interface JmsProductService {

    void sendNewProductCreated(ProductCreatedMessage message);
}
