package com.myrotiuk.auction.middleware.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.myrotiuk.auction.model.category.Category;

/**
 * Created by pav on 2/12/15.
 */
public interface CategoryRepository  extends MongoRepository<Category, ObjectId>, CategoryRepositoryCustom {

    Category findByName(String name);
}
