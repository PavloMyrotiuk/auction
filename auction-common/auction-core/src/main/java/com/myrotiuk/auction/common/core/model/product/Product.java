package com.myrotiuk.auction.common.core.model.product;

import com.myrotiuk.auction.common.core.model.BaseEntity;
import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Version;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pav on 1/29/15.
 */
@Document(collection = "products")
public class Product implements BaseEntity<ObjectId> {


    public enum KEY {
        ID("id"),
        ADDED_DATE("addedDate"),
        VALID_DATE("validDate"),
        PRICE("price"),
        TITLE("title"),
        DESCRIPTION("description"),
        PRODUCT_STATUS("productStatus"),
        CATEGORY("category"),
        OWNER("owner"),
        WINNER("winner"),
        BET("bets");

        KEY(String name) {
            this.keyName = name;
        }

        private String keyName;

        @Override
        public String toString() {
            return this.keyName;
        }
    }

    @Version
    private Long version;

    @Id
    private ObjectId id;
    private Date addedDate;
    private Date validDate;
    private BigDecimal price;
    private String title;
    private String description;
    private ProductStatus productStatus;
    @Indexed
    private String category;
    @DBRef
    private User owner;
    @DBRef
    private User winner;

    private List<Bet> bets;

    public Long getVersion() {
        return version;
    }

    @Override
    public ObjectId getId() {
        return id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setId(ObjectId id) {
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

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public void addBet(Bet bet){
        if (bets == null ) bets = new ArrayList<>();
        this.bets.add(bet);
    }
}
