package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.message.ProductCreatedMessage;

/**
 * Created by pav on 2/2/15.
 */
public interface JmsProductService {
    void sendNewProductCreatedMessage(ProductCreatedMessage message);
}
