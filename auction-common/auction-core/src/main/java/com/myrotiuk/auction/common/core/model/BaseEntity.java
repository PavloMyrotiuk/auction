package com.myrotiuk.auction.common.core.model;

import java.io.Serializable;

/**
 * Created by pav on 2/11/15.
 */
public interface BaseEntity<ID extends Serializable> {
    ID getId();
}
