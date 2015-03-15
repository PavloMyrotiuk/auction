package com.myrotiuk.auction.middleware.web.vo;

import java.math.BigDecimal;

/**
 * Created by pav on 3/14/15.
 */
public class BetVO {
    private String productId;
    private BigDecimal amount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
