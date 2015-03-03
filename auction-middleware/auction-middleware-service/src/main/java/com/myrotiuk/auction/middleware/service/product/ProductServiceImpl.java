package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.message.ProductCreatedMessage;
import com.myrotiuk.auction.middleware.persistence.repository.ProductRepository;
import com.myrotiuk.auction.middleware.service.BaseEntityServiceImpl;
import com.myrotiuk.auction.model.product.Product;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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
    private JmsTemplate jmsTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void sendCreatedProductMessage(Product product) {
        jmsTemplate.convertAndSend(conversionService.convert(product, ProductCreatedMessage.class));
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
