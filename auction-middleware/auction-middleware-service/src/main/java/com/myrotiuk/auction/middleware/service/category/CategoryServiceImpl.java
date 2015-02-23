package com.myrotiuk.auction.middleware.service.category;

import com.myrotiuk.auction.middleware.persistence.repository.CategoryRepository;
import com.myrotiuk.auction.model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pav on 2/13/15.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category entity) {
       return  categoryRepository.save(entity);
    }

    @Override
    public List<Category> findParentCategories() {
        return categoryRepository.findParentCategories();
    }

    @Override
    public List<Category> findSubCategories(String parentCategoryName) {
        return categoryRepository.findSubCategories(parentCategoryName);
    }
}
