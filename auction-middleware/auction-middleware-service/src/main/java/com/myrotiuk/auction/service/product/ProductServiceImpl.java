package com.myrotiuk.auction.service.product;

import com.myrotiuk.auction.model.message.ProductCreatedMessage;
import com.myrotiuk.auction.model.product.Product;
import com.myrotiuk.auction.service.ProductService;
import com.myrotiuk.auction.jms.service.JmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pav on 1/31/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private JmsProductService jmsProductService;

    @Override
    public void sendCreatedProductMessage(Product product) {
        ProductCreatedMessage message = new ProductCreatedMessage();
        message.setProductId(product.getId());
        jmsProductService.sendNewProductCreatedMessage(message);
    }
}
