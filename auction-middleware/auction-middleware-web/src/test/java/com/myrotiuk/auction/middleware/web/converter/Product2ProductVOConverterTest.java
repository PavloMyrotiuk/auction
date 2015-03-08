package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.middleware.web.vo.ProductVO;
import com.myrotiuk.auction.common.core.model.product.Product;
import com.myrotiuk.auction.common.core.model.product.ProductStatus;
import com.myrotiuk.auction.common.core.model.user.User;
import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class Product2ProductVOConverterTest {


    private static Product2ProductVOConverter converter;

    @BeforeClass
    public static void init(){
        converter = new Product2ProductVOConverter();
    }

    @Test
    public void testConvertValidProduct2ProductVOShouldReturnPopulatedProductVO(){
        Date added = new Date();
        Date valid = new Date();
        User owner = new User();
        owner.setId(ObjectId.get());
        User winner = new User();
        winner.setId(ObjectId.get());
        ObjectId productId = ObjectId.get();

        Product product = new Product();
        product.setId(productId);
        product.setAddedDate(added);
        product.setValidDate(valid);
        product.setCategory("phone");
        product.setDescription("simple description");
        product.setPrice(BigDecimal.TEN);
        product.setProductStatus(ProductStatus.VALID);
        product.setTitle("Title");
        product.setVersion(Long.valueOf(41));
        product.setOwner(owner);
        product.setWinner(winner);

        ProductVO productVO = converter.convert(product);
        assertEquals(productId.toString(), productVO.getId());
        assertEquals(Long.valueOf(added.getTime()), productVO.getAddedDate());
        assertEquals(Long.valueOf(valid.getTime()), productVO.getValidDate());
        assertEquals(owner.getId().toString(), productVO.getUserId());
        assertEquals(winner.getId().toString(), productVO.getWinnerId());
        assertEquals(Long.valueOf(41),productVO.getVersion());
        assertEquals("simple description", productVO.getDescription());
        assertEquals(BigDecimal.TEN, productVO.getPrice());
        assertEquals(ProductStatus.VALID.toString(), productVO.getProductStatus());
        assertEquals("Title", productVO.getTitle());
        assertEquals("phone", productVO.getCategory());
    }

    @Test
    public void testConvertNullProduct2ProductVOShouldReturnNull(){
        Product product = null;
        ProductVO productVO = converter.convert(product);
        assertThat(productVO, is(nullValue()));

    }
}