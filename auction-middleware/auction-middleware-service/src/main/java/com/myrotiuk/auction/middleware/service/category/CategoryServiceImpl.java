package com.myrotiuk.auction.middleware.service.category;

import com.myrotiuk.auction.common.persistence.repository.CategoryRepository;
import com.myrotiuk.auction.middleware.service.BaseEntityServiceImpl;
import com.myrotiuk.auction.common.core.model.category.Category;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pav on 2/13/15.
 */
@Service
public class CategoryServiceImpl extends BaseEntityServiceImpl<Category> implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findCategoryHierarchy() {
        return categoryRepository.findCategoriesHierarchy();
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    protected MongoRepository<Category, ObjectId> getRepository() {
        return categoryRepository;
    }
}
