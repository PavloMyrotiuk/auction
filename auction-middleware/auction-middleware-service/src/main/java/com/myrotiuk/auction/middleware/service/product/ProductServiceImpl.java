package com.myrotiuk.auction.middleware.service.product;

import com.myrotiuk.auction.common.jms.annotation.CreatedProductTemplate;
import com.myrotiuk.auction.message.ProductCreatedMessage;
import com.myrotiuk.auction.model.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 1/31/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @CreatedProductTemplate
    private JmsTemplate jmsTemplate;

    @Autowired
    private ConversionService conversionService;

    @Override
    public void sendCreatedProductMessage(Product product) {
        jmsTemplate.convertAndSend(conversionService.convert(product, ProductCreatedMessage.class));
    }

    @Override
    public Product create(Product entity) {
        return null;
    }
}
