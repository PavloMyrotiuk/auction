package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.CategoryVO;
import com.myrotiuk.auction.model.category.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 2/26/15.
 */
@Component
public class Category2CategoryVOConverter implements Converter<Category, CategoryVO> {

    private CustomConversionService customConversionService;

    @Override
    public CategoryVO convert(Category source) {
        CategoryVO result = new CategoryVO();
        result.setId(source.getId().toString());
        result.setName(source.getName());
        result.setChildrenCategories(customConversionService.convertAll(source.getChildrenCategories(), CategoryVO.class));
        return result;
    }

    public void setCustomConversionService(CustomConversionService customConversionService) {
        this.customConversionService = customConversionService;
    }
}
