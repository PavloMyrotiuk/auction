package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pav on 2/13/15.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("permitAll")
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getParentCategories() {
        return categoryService.findParentCategories();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Category addCategory(@PathVariable("name") String name) {
        Category c = new Category();
        c.setName(name);
        return categoryService.create(c);
    }
}
