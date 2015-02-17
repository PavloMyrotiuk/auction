package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.model.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pav on 2/13/15.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Category addCategory(@PathVariable("name") String name) {
        Category c = new Category();
        c.setName(name);
        categoryService.createCategory(c);
        return c;
    }
}
