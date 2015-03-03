package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.service.category.CategoryService;
import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.model.product.Product;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
        result.setAddedDate(source.getAddedDate());
        result.setValidDate(source.getValidDate());
        result.setCategory(source.getCategory());
        result.setOwner(source.getUserId()!=null?userService.findById(new ObjectId(source.getUserId())):null);
        result.setDescription(source.getDescription());
        result.setPrice(source.getPrice());
        result.setProductStatus(source.getProductStatus());
        result.setTitle(source.getTitle());
        return result;
    }
}
