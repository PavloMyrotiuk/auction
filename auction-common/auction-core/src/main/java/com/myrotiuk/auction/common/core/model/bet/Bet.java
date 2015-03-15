package com.myrotiuk.auction.common.core.model.bet;

import com.myrotiuk.auction.common.core.model.user.User;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

/**
 * Created by pav on 3/14/15.
 */
public class Bet {

    @DBRef
    private User user;
    private BigDecimal amount;

    public Bet(User user, BigDecimal amount) {
        this.user = user;
        this.amount = amount;
    }

    public Bet() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
