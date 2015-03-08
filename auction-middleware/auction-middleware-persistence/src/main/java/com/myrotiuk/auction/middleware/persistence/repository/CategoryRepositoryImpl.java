package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.common.core.model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pav on 2/22/15.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Category> findCategoriesHierarchy() {
        Criteria childrenCategoryExists = Criteria.where(Category.KEY.CHILDREN_CATEGORY.toString()).exists(true);
        Criteria childrenCategoryIsNotEmpty = Criteria.where("$where").is("this."+Category.KEY.CHILDREN_CATEGORY.toString()+".length>0");
        Query query = new Query(new Criteria().andOperator(childrenCategoryExists, childrenCategoryIsNotEmpty));
        return mongoOperations.find(query, Category.class);
    }
}
