package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.common.jms.annotation.BetQueueTemplate;
import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.common.persistence.repository.ProductRepository;
import com.myrotiuk.auction.middleware.service.BaseEntityServiceImpl;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.middleware.service.message.MessageFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pav on 1/31/15.
 */
@Service
public class ProductServiceImpl extends BaseEntityServiceImpl<Product> implements ProductService {

    @Autowired
    @CreatedProductTemplate
    private JmsTemplate createProductTemplate;

    @Autowired
    @BetQueueTemplate
    private JmsTemplate betQueueTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MessageFactory messageFactory;

    @Override
    public void sendCreatedProductMessage(Product product) {
        createProductTemplate.convertAndSend(messageFactory.getProductCreatedMessage(product));
    }

    @Override
    public void sendBetProductMessage(Bet bet, ObjectId productId) {
        betQueueTemplate.convertAndSend(messageFactory.getBetMessage(bet, productId));
    }

    @Override
    public Product create(Product entity) {
        Product product = super.create(entity);
        sendCreatedProductMessage(product);
        return product;
    }

    @Override
    public List<Product> findProducts(Product template) {
        return productRepository.findProducts(template);
    }

    @Override
    protected MongoRepository<Product, ObjectId> getRepository() {
        return productRepository;
    }
}
