package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.CategoryVO;
import com.myrotiuk.auction.model.category.Category;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by pav on 2/26/15.
 */
public class Category2CategoryVOConverter implements Converter<Category, CategoryVO> {

    @Override
    public CategoryVO convert(Category source) {
        CategoryVO result = new CategoryVO();
        result.setId(source.getId().toString());
        result.setName(source.getName());
        return result;
    }
}
