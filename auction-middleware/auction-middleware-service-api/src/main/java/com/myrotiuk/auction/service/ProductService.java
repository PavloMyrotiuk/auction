package com.myrotiuk.auction.service;

import com.myrotiuk.auction.model.product.Product;

/**
 * Created by pav on 1/31/15.
 */
public interface ProductService {

    void sendCreatedProductMessage(Product product);
}
