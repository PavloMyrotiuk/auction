package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.model.product.Product;
import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by pav on 1/30/15.
 */
public class Product2ProductVOConverter implements Converter<Product, ProductVO> {
    @Override
    public ProductVO convert(Product source) {
        ProductVO result = new ProductVO();
        result.setDescription(source.getDescription());
        result.setId(source.getId());
        result.setPrice(source.getPrice());
        result.setProductStatus(source.getProductStatus());
        result.setTitle(source.getTitle());
        return result;
    }
}
