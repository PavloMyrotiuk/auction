package com.myrotiuk.auction.middleware.service.message;

import com.myrotiuk.auction.common.core.message.BetMessage;
import com.myrotiuk.auction.common.core.message.MessageType;
import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.product.Product;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/8/15.
 */
@Component
public class MessageFactoryImpl implements MessageFactory {

    @Override
    public ProductCreatedMessage getProductCreatedMessage(Product product) {
        ProductCreatedMessage result = new ProductCreatedMessage();
        result.setProductId(product.getId().toString());
        result.setMessageType(MessageType.PRODUCT_CREATED);
        result.setValidDate(product.getValidDate().getTime());
        return result;
    }

    @Override
    public BetMessage getBetMessage(Bet bet, ObjectId productId) {
        BetMessage result = new BetMessage();
        result.setUserId(bet.getUser().getId().toString());
        result.setBetAmount(bet.getAmount());
        result.setProductId(productId.toString());
        result.setMessageType(MessageType.BET);
        return result;
    }
}
