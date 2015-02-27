package com.myrotiuk.auction.middleware.web.vo;

import java.util.List;

/**
 * Created by pav on 2/24/15.
 */
public class CategoryVO {

    private String id;

    private String name;

    private List<CategoryVO> childrenCategories;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryVO> getChildrenCategories() {
        return childrenCategories;
    }

    public void setChildrenCategories(List<CategoryVO> childrenCategories) {
        this.childrenCategories = childrenCategories;
    }
}
