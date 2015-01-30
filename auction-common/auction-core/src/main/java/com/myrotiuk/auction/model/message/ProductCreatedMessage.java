package com.myrotiuk.auction.model.message;

/**
 * Created by pav on 1/30/15.
 */
public class ProductCreatedMessage {
    private long productId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
