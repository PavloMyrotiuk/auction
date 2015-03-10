package com.myrotiuk.auction.middleware.web.controller;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private CustomConversionService conversionService;

    @PreAuthorize("permitAll")
    @RequestMapping(value = "/hierarchy", method = RequestMethod.GET)
    public List<CategoryVO> getHierarchy() {
        return conversionService.convertAll(categoryService.findCategoryHierarchy(), CategoryVO.class);
    }


}
