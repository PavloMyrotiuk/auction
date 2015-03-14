package com.myrotiuk.auction.common.core.message;

import org.bson.types.ObjectId;

import java.math.BigDecimal;

/**
 * Created by pav on 3/14/15.
 */
public class BetMessage extends BaseMessage{


    private ObjectId productId;

    private ObjectId userId;

    private BigDecimal betAmount;

    public ObjectId getProductId() {
        return productId;
    }

    public void setProductId(ObjectId productId) {
        this.productId = productId;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }
}
