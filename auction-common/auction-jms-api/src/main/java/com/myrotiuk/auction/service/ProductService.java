package com.myrotiuk.auction.service;

import com.myrotiuk.auction.model.message.ProductCreatedMessage;

/**
 * Created by pav on 1/30/15.
 */
public interface ProductService {

    void sendNewProductCreated(ProductCreatedMessage message);
}
