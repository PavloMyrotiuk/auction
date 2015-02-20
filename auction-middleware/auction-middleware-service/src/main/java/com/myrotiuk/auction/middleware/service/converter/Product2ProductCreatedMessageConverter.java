package com.myrotiuk.auction.middleware.service.converter;

import com.myrotiuk.auction.message.ProductCreatedMessage;
import com.myrotiuk.auction.model.product.Product;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by pav on 2/20/15.
 */
public class Product2ProductCreatedMessageConverter implements Converter<Product, ProductCreatedMessage> {

    @Override
    public ProductCreatedMessage convert(Product source) {
        ProductCreatedMessage result = new ProductCreatedMessage();
        result.setProductId(source.getId());
        return result;
    }
}
