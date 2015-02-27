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
        ProductVO result = new ProductVO();
        result.setDescription(source.getDescription());
        result.setId(source.getId().toString());
        result.setPrice(source.getPrice());
        result.setProductStatus(source.getProductStatus());
        result.setTitle(source.getTitle());
        return result;
    }
}
