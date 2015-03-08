package com.myrotiuk.auction.middleware.web.converter.service;

import com.myrotiuk.auction.middleware.web.converter.Category2CategoryVOConverter;
import com.myrotiuk.auction.middleware.web.vo.CategoryVO;
import com.myrotiuk.auction.common.core.model.category.Category;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class CustomConversionServiceTest {

    private static CustomConversionService conversionService;

    @BeforeClass
    public static void init() {
        conversionService = new CustomConversionService();
        Category2CategoryVOConverter converter = new Category2CategoryVOConverter();
        conversionService.addConverter(converter);
        converter.setCustomConversionService(conversionService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertAllTargetTypeIsNullShouldThrowException() {
        conversionService.convertAll(new ArrayList<>(), null);
    }

    @Test
    public void testConvertAllNullListShouldReturnNull() {
        List<CategoryVO> categories = conversionService.convertAll(null, CategoryVO.class);
        assertThat(categories, is(nullValue()));
    }

    @Test
    public void testConvertListCategoriesShouldReturnListWithTheSameAmountOfElements(){
        List<Category> categories = new ArrayList<>();
        Category phoneCategory = new Category();
        Category notebookCategory = new Category();
        Category tabletCategory = new Category();
        categories.add(phoneCategory);
        categories.add(notebookCategory);
        categories.add(tabletCategory);

        List<CategoryVO> categoryVOs = conversionService.convertAll(categories, CategoryVO.class);
        assertEquals(3, categoryVOs.size());
    }

    @Test
    public void testConvertListCategoriesConvertedElementsClassShouldBeAsTargetType(){
        List<Category> categories = new ArrayList<>();
        Category phoneCategory = new Category();
        categories.add(phoneCategory);

        List<CategoryVO> categoryVOs = conversionService.convertAll(categories, CategoryVO.class);
        assertEquals(CategoryVO.class, categoryVOs.get(0).getClass());
    }
}