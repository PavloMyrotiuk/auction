package com.myrotiuk.auction.common.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.myrotiuk.auction.common.core.model.category.Category;

/**
 * Created by pav on 2/12/15.
 */
public interface CategoryRepository  extends MongoRepository<Category, ObjectId>, CategoryRepositoryCustom {
}
