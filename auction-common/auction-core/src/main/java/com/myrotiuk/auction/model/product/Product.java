package com.myrotiuk.auction.model.product;

import com.myrotiuk.auction.model.BaseEntity;
import com.myrotiuk.auction.model.category.Category;
import com.myrotiuk.auction.model.user.User;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Version;

import java.math.BigDecimal;
import java.util.Date;

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
        WINNER("winner");

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
    private int version;

    @Id
    private ObjectId id;
    private Date addedDate;
    private Date validDate;
    private BigDecimal price;
    private String title;
    private String description;
    private ProductStatus productStatus;
    @DBRef
    private Category category;
    @DBRef
    private User owner;
    @DBRef
    private User winner;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public ObjectId getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
}
