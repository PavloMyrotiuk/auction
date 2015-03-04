package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.model.product.Product;
import com.myrotiuk.auction.model.product.ProductStatus;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by pav on 3/3/15.
 */
@Component
public class ProductVO2ProductConverter implements Converter<ProductVO, Product> {

    @Autowired
    private UserService userService;

    @Override
    public Product convert(ProductVO source) {
        if (source == null) return null;

        Product result = new Product();
        result.setAddedDate(getValue(source.getAddedDate())!=null?new Date(Integer.parseInt(getValue(source.getAddedDate()))):null);
        result.setValidDate(getValue(source.getValidDate())!=null?new Date(Integer.parseInt(getValue(source.getValidDate()))):null);
        result.setCategory(getValue(source.getCategory()));
        result.setOwner(getValue(source.getUserId()) != null ? userService.findById(new ObjectId(getValue(source.getUserId()))) : null);
        result.setDescription(getValue(source.getDescription()));
        result.setPrice(source.getPrice());
        result.setProductStatus(getValue(source.getProductStatus())!=null?ProductStatus.valueOf(source.getProductStatus()):null);
        result.setTitle(getValue(source.getTitle()));
        return result;
    }

    private String getValue(String source) {
        if (source == null || source == "") {
            return null;
        } else {
            return source;
        }
    }
}
