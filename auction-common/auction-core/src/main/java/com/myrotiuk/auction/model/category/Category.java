package com.myrotiuk.auction.model.category;

import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * Created by pav on 2/11/15.
 */
@Document(collection = "categories")
public class Category implements BaseEntity<ObjectId> {

    @Id
    private ObjectId id;

    @DBRef
    private Category parentCategory;

    private String name;


    @Override
    public ObjectId getId() {
        return id;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
