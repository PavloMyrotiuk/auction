package com.myrotiuk.auction.common.core.message;

/**
 * Created by pav on 1/30/15.
 */
public class ProductCreatedMessage extends BaseMessage{

    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
