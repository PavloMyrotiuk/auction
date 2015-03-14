package com.myrotiuk.auction.common.core.message;

import org.bson.types.ObjectId;

/**
 * Created by pav on 1/30/15.
 */
public class ProductCreatedMessage extends BaseMessage{

    private ObjectId productId;

    public ObjectId getProductId() {
        return productId;
    }

    public void setProductId(ObjectId productId) {
        this.productId = productId;
    }
}
