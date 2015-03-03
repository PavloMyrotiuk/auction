package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.model.product.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 1/30/15.
 */
@Component
public class Product2ProductVOConverter implements Converter<Product, ProductVO> {
    @Override
    public ProductVO convert(Product source) {
        if(source == null) return null;

        ProductVO result = new ProductVO();

        result.setId(source.getId()!=null? source.getId().toString():null);
        result.setTitle(source.getTitle());
        result.setDescription(source.getDescription());
        result.setCategory(source.getCategory());

        result.setPrice(source.getPrice());
        result.setProductStatus(source.getProductStatus());
        result.setAddedDate(source.getAddedDate());
        result.setValidDate(source.getValidDate());
        result.setUserId(source.getOwner()!=null?source.getOwner().getId().toString():null);
        result.setWinnerId(source.getWinner()!=null?source.getWinner().getId().toString():null);

        return result;
    }
}
