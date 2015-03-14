package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.service.user.UserService;
import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.common.core.model.product.ProductStatus;
import com.myrotiuk.auction.common.core.model.user.User;
import com.myrotiuk.auction.middleware.web.vo.UserVO;
import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductVO2ProductConverterTest {

    @InjectMocks
    private static ProductVO2ProductConverter converter;

    @BeforeClass
    public static void init(){
        converter = new ProductVO2ProductConverter();
    }

    @Test
    public void testConvertValidProductVO2ProductShouldReturnValidProductObject(){
        ObjectId id = ObjectId.get();
        Date date = new Date();


        ProductVO productVO= new ProductVO();
        productVO.setId(id.toString());
        productVO.setAddedDate(date.getTime());
        productVO.setValidDate(date.getTime());
        productVO.setCategory("phone");
        productVO.setDescription("simple description");
        productVO.setPrice(BigDecimal.TEN);
        productVO.setProductStatus(ProductStatus.VALID.toString());
        productVO.setTitle("Title");
        productVO.setVersion(Long.valueOf(41));

        Product product = converter.convert(productVO);

        assertEquals(id, product.getId());
        assertEquals(date, product.getAddedDate());
        assertEquals(date, product.getValidDate());
        assertEquals(Long.valueOf(41), product.getVersion());
        assertEquals("simple description", product.getDescription());
        assertEquals(BigDecimal.TEN, product.getPrice());
        assertEquals(ProductStatus.VALID, product.getProductStatus());
        assertEquals("Title", product.getTitle());
        assertEquals("phone", product.getCategory());

    }

    @Test
    public void testConvertNullProductVO2ProductShouldReturnValidProduct(){
        ProductVO productVO = null;
        Product product = converter.convert(productVO);
        assertThat(product, is(nullValue()));
    }



}