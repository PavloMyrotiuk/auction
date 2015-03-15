package com.myrotiuk.auction.middleware.web.vo;

import com.myrotiuk.auction.common.core.model.bet.Bet;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pav on 1/29/15.
 */
public class ProductVO {
    private String id;
    private Long addedDate;
    private Long validDate;
    private BigDecimal price;
    private String title;
    private String description;
    private String  productStatus;
    private String category;
    private UserVO user;
    private UserVO winner;
    private Long version;
    private List<Bet> bets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Long addedDate) {
        this.addedDate = addedDate;
    }

    public Long getValidDate() {
        return validDate;
    }

    public void setValidDate(Long validDate) {
        this.validDate = validDate;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public UserVO getWinner() {
        return winner;
    }

    public void setWinner(UserVO winner) {
        this.winner = winner;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
