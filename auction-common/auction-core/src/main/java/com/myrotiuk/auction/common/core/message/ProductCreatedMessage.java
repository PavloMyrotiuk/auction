package com.myrotiuk.auction.common.core.message;

/**
 * Created by pav on 1/30/15.
 */
public class ProductCreatedMessage extends BaseMessage{

    private String productId;

    private Long validDate;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getValidDate() {
        return validDate;
    }

    public void setValidDate(Long validDate) {
        this.validDate = validDate;
    }
}
