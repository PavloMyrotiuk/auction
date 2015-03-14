package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.middleware.service.BaseEntityService;
import com.myrotiuk.auction.common.core.model.product.Product;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by pav on 1/31/15.
 */
public interface ProductService extends BaseEntityService<Product> {

    void sendCreatedProductMessage(Product product);

    void sendBetProductMessage(Bet bet, ObjectId productId);

    List<Product> findProducts(Product template);
}
