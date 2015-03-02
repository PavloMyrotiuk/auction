package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.model.product.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pav on 2/12/15.
 */
public interface ProductRepository extends MongoRepository<Product, ObjectId>, ProductRepositoryCustom {
}
