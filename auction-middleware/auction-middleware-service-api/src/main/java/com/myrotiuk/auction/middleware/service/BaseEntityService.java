package com.myrotiuk.auction.middleware.service;


import com.myrotiuk.auction.model.BaseEntity;

/**
 * Created by pav on 2/20/15.
 */
public interface BaseEntityService<E extends BaseEntity> {

    E create(E entity);
}
