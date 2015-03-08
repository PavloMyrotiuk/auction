package com.myrotiuk.auction.middleware.service.message;

import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.common.core.model.product.Product;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/8/15.
 */
@Component
public class MessageFactoryImpl implements MessageFactory {

    @Override
    public ProductCreatedMessage getProductCreatedMessage(Product product) {
        ProductCreatedMessage result = new ProductCreatedMessage();
        result.setProductId(product.getId());
        return result;
    }
}
