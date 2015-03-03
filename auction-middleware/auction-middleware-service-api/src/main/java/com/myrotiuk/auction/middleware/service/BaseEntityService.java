package com.myrotiuk.auction.middleware.service;


import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;


/**
 * Created by pav on 2/20/15.
 */
public interface BaseEntityService<E extends BaseEntity<ObjectId>> {

    E create(E entity);

    E findById(ObjectId id);
}
