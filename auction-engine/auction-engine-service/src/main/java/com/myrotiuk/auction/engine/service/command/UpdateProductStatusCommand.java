package com.myrotiuk.auction.engine.service.command;

import com.myrotiuk.auction.common.core.model.product.ProductStatus;
import com.myrotiuk.auction.common.persistence.repository.ProductRepository;
import org.bson.types.ObjectId;

/**
 * Created by pav on 3/22/15.
 */
public class UpdateProductStatusCommand implements Command{

    private ObjectId productId;

    private ProductRepository productRepository;

    public UpdateProductStatusCommand(ObjectId productId, ProductRepository productRepository) {
        this.productId = productId;
        this.productRepository = productRepository;
    }

    public void execute() {
        productRepository.updateProductStatus(productId, ProductStatus.EXPIRED);
    }
}
