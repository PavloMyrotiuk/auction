package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.CategoryVO;
import com.myrotiuk.auction.common.core.model.category.Category;
import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Category2CategoryVOConverterTest {

    @InjectMocks
    private static Category2CategoryVOConverter converter;

    @Mock
    private CustomConversionService customConversionService;

    @BeforeClass
    public static void init(){
        converter = new Category2CategoryVOConverter();
    }


    @Test
    public void testConvertValidCategory2CategoryVOShouldReturnValidCategoryVO(){
        ObjectId id = ObjectId.get();
        List<Category> childrenCategories = mock(List.class);
        List<CategoryVO> childrenCategoriesVO = mock(List.class);

        when(customConversionService.convertAll(childrenCategories, CategoryVO.class)).thenReturn(childrenCategoriesVO);

        Category category = new Category();
        category.setName("gold");
        category.setId(id);
        category.setChildrenCategories(childrenCategories);

        CategoryVO categoryVO = converter.convert(category);
        assertEquals("gold", categoryVO.getName());
        assertEquals(id.toString(), categoryVO.getId());
        assertEquals(childrenCategoriesVO, categoryVO.getChildrenCategories());

        verify(customConversionService, times(1)).convertAll(childrenCategories, CategoryVO.class);
    }

    @Test
    public void testConvertNullCategory2CategoryVOShouldReturnNull(){
        Category category = null;
        CategoryVO categoryVO = converter.convert(category);
        assertThat(categoryVO, is(nullValue()));

    }


}