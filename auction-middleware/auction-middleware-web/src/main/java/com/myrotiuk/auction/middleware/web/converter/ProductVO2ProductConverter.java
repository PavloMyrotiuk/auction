package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.common.core.model.product.ProductStatus;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by pav on 3/3/15.
 */
@Component
public class ProductVO2ProductConverter implements Converter<ProductVO, Product> {

    @Override
    public Product convert(ProductVO source) {
        if (source == null) return null;

        Product result = new Product();
        result.setId(getValue(source.getId())!=null?new ObjectId(source.getId()):null);
        result.setVersion(getValue(source.getVersion())!=null?source.getVersion():null);
        result.setAddedDate(getValue(source.getAddedDate())!=null?new Date(source.getAddedDate()):null);
        result.setValidDate(getValue(source.getValidDate())!=null?new Date(source.getValidDate()):null);
        result.setCategory(getValue(source.getCategory()));
        result.setDescription(getValue(source.getDescription()));
        result.setPrice(source.getPrice());
        result.setProductStatus(getValue(source.getProductStatus())!=null?ProductStatus.valueOf(source.getProductStatus()):null);
        result.setTitle(getValue(source.getTitle()));
        return result;
    }

    private <E> E getValue(E source) {
        if (source == null || source == "") {
            return null;
        } else {
            return source;
        }
    }
}
