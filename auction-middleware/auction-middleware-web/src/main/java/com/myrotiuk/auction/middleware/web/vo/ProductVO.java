package com.myrotiuk.auction.middleware.web.vo;

import com.myrotiuk.auction.model.product.ProductStatus;

import java.math.BigDecimal;

/**
 * Created by pav on 1/29/15.
 */
public class ProductVO {
    private String id;
    private BigDecimal price;
    private String title;
    private String description;
    private ProductStatus  productStatus;
    private String category;

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
}
