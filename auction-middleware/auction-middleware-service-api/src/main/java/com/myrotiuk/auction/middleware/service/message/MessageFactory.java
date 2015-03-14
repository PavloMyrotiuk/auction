package com.myrotiuk.auction.middleware.service.message;

import com.myrotiuk.auction.common.core.message.BetMessage;
import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.product.Product;
import org.bson.types.ObjectId;

/**
 * Created by pav on 3/8/15.
 */
public interface MessageFactory {

    ProductCreatedMessage getProductCreatedMessage(Product product);

    BetMessage getBetMessage(Bet bet, ObjectId productId);
}
