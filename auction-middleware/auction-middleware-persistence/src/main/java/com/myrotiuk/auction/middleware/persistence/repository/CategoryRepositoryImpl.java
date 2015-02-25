package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.model.category.Category;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pav on 2/22/15.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    private MongoOperations mongoOperations;

    @Override
    public List<Category> findParentCategories() {
//        Criteria parentCategoryDoesNotExists = Criteria.where(Category.KEY.PARENT_CATEGORY.toString()).exists(false);
//        Criteria parentCategoryIsEmpty = Criteria.where(Category.KEY.PARENT_CATEGORY.toString()).size();
//        return mongoOperations.find(new Query(Criteria.orOperator(,
//                Criteria.where(Category.KEY.PARENT_CATEGORY.toString()))), Category.class);
        return null;
    }

    @Override
    public List<Category> findSubCategories(ObjectId parentCategoryId) {
        return null;
    }
}
