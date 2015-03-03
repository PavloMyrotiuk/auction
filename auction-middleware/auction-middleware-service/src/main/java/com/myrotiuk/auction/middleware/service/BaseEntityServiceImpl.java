package com.myrotiuk.auction.middleware.service;

import com.myrotiuk.auction.model.BaseEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by pav on 3/3/15.
 */
public abstract class BaseEntityServiceImpl<E extends BaseEntity<ObjectId>> implements BaseEntityService<E> {

    protected  abstract MongoRepository<E, ObjectId> getRepository();

    @Override
    public E create(E entity) {
        return getRepository().save(entity);
    }

    @Override
    public E findById(ObjectId id) {
        return getRepository().findOne(id);
    }
}
