package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.model.category.Category;

import java.util.List;

/**
 * Created by pav on 2/22/15.
 */
public interface CategoryRepositoryCustom {

    List<Category> findCategoriesHierarchy();
}
