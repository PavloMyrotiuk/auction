package com.myrotiuk.auction.common.core.message;

import java.math.BigDecimal;

/**
 * Created by pav on 3/14/15.
 */
public class BetMessage extends BaseMessage{


    private String productId;

    private String userId;

    private BigDecimal betAmount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
