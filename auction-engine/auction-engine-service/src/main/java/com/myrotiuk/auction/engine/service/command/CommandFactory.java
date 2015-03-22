package com.myrotiuk.auction.engine.service.command;

import com.myrotiuk.auction.common.persistence.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/22/15.
 */
@Component
public class CommandFactory {

    @Autowired
    private ProductRepository productRepository;

    public Command getUpdateProductStatusCommand(ObjectId productId){
        return new UpdateProductStatusCommand(productId, productRepository);
    }
}
