package com.myrotiuk.auction.model.category;

import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


/**
 * Created by pav on 2/11/15.
 */
@Document(collection = "categories")
public class Category implements BaseEntity<ObjectId> {

    public enum KEY{
        ID("id"),
        NAME("name"),
        CHILDREN_CATEGORY("childrenCategories");

        KEY(String name) {
            this.keyName = name;
        }
        private String keyName;

        @Override
        public String toString() {
            return this.keyName;
        }
    }

    @Id
    private ObjectId id;

    @DBRef
    private List<Category> childrenCategories;

    @Indexed(unique = true, sparse = true)
    private String name;


    @Override
    public ObjectId getId() {
        return id;
    }

    public List<Category> getChildrenCategories() {
        return childrenCategories;
    }

    public void setChildrenCategories(List<Category> childrenCategories) {
        this.childrenCategories = childrenCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
