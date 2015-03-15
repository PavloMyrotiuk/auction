package com.myrotiuk.auction.engine.service.message;

import com.myrotiuk.auction.common.core.message.BetMessage;
import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.common.persistence.repository.ProductRepository;
import com.myrotiuk.auction.common.persistence.repository.UserRepository;
import com.myrotiuk.auction.engine.service.annotation.BetMessageProcessorQualifier;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/15/15.
 */
@Component
@BetMessageProcessorQualifier
public class BetMessageProcessor implements MessageProcessor<BetMessage> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void process(BetMessage message) {
        Product product = productRepository.findOne(new ObjectId(message.getProductId()));
        User user = userRepository.findOne(new ObjectId(message.getUserId()));
        Bet bet = new Bet(user, message.getBetAmount());
        product.addBet(bet);
        productRepository.save(product);
    }
}
