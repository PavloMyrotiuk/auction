package com.myrotiuk.auction.middleware.service.message;

import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.common.core.model.product.Product;

/**
 * Created by pav on 3/8/15.
 */
public interface MessageFactory {

    ProductCreatedMessage getProductCreatedMessage(Product product);
}
