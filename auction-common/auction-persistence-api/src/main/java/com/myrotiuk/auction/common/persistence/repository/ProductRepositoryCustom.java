package com.myrotiuk.auction.common.persistence.repository;

import com.myrotiuk.auction.common.core.model.product.Product;

import java.util.List;

/**
 * Created by pav on 3/1/15.
 */
public interface ProductRepositoryCustom {

    List<Product> findProducts(Product template);
}
