package com.myrotiuk.auction.common.persistence.repository;

import com.myrotiuk.auction.common.core.model.category.Category;

import java.util.List;

/**
 * Created by pav on 2/22/15.
 */
public interface CategoryRepositoryCustom {

    List<Category> findCategoriesHierarchy();
}
