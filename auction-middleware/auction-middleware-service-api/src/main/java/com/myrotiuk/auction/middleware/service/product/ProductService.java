package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.middleware.service.BaseEntityService;
import com.myrotiuk.auction.model.product.Product;

/**
 * Created by pav on 1/31/15.
 */
public interface ProductService extends BaseEntityService<Product> {

    void sendCreatedProductMessage(Product product);
}
