package com.myrotiuk.auction.common.persistence.repository;

import com.myrotiuk.auction.common.core.model.product.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pav on 2/12/15.
 */
public interface ProductRepository extends MongoRepository<Product, ObjectId>, ProductRepositoryCustom {
}
