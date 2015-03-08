package com.myrotiuk.auction.engine.service.product;

import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;

/**
 * Created by pav on 2/2/15.
 */
public interface JmsProductService {

    void readNewProductCreatedMessage(ProductCreatedMessage message);
}
