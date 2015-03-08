package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.common.core.model.product.Product;
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
        result.setVersion(source.getVersion());
        result.setTitle(source.getTitle());
        result.setDescription(source.getDescription());
        result.setCategory(source.getCategory());

        result.setPrice(source.getPrice());
        result.setProductStatus(source.getProductStatus()!=null?source.getProductStatus().toString():null);
        result.setAddedDate(source.getAddedDate()!=null?source.getAddedDate().getTime():null);
        result.setValidDate(source.getValidDate()!=null?source.getValidDate().getTime():null);
        result.setUserId(source.getOwner()!=null?source.getOwner().getId().toString():null);
        result.setWinnerId(source.getWinner()!=null?source.getWinner().getId().toString():null);

        return result;
    }
}
