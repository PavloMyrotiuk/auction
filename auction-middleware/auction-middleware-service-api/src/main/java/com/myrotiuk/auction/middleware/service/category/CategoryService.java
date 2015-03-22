package com.myrotiuk.auction.middleware.service.category;

import com.myrotiuk.auction.middleware.service.BaseEntityService;
import com.myrotiuk.auction.common.core.model.category.Category;

import java.util.List;

/**
 * Created by pav on 2/13/15.
 */
public interface CategoryService extends BaseEntityService<Category> {
    List<Category> findCategoryHierarchy();
}
