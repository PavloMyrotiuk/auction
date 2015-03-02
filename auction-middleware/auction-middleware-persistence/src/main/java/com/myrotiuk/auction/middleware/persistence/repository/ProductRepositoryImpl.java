package com.myrotiuk.auction.middleware.persistence.repository;

import com.myrotiuk.auction.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pav on 3/1/15.
 */
@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Product> findProducts(Product template) {
        List<Criteria> criterias = new ArrayList<>(Product.KEY.values().length);

        if (template.getCategory() != null) {
            criterias.add(getCriteria(Product.KEY.CATEGORY, template.getCategory()));
        }
        if (template.getOwner() != null) {
            criterias.add(getCriteria(Product.KEY.OWNER, template.getOwner()));
        }
        if (template.getAddedDate() != null){
            criterias.add(getCriteria(Product.KEY.ADDED_DATE, template.getAddedDate()));
        }
        if (template.getTitle() != null){
            criterias.add(getCriteria(Product.KEY.TITLE, template.getTitle()));
        }
        if (template.getValidDate() != null){
            criterias.add(getCriteria(Product.KEY.VALID_DATE, template.getValidDate()));
        }

        Query query = new Query(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
        return mongoOperations.find(query, Product.class);
    }

    private Criteria getCriteria(Product.KEY key, Object value) {
        Criteria criteria = Criteria.where(key.toString()).is(value);
        return criteria;
    }


}
