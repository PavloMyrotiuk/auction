package com.myrotiuk.auction.middleware.web.converter;

import com.myrotiuk.auction.common.core.model.bet.Bet;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import com.myrotiuk.auction.middleware.web.vo.BetVO;
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
import org.springframework.core.convert.ConversionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class Product2ProductVOConverterTest {

    @Mock
    private CustomConversionService conversionService;

    @InjectMocks
    private static Product2ProductVOConverter converter;

    @BeforeClass
    public static void init(){
        converter = new Product2ProductVOConverter();
    }

    @Test
    public void testConvertValidProduct2ProductVOShouldReturnPopulatedProductVO(){
        Date date = new Date();
        User user = new User();
        user.setId(ObjectId.get());

        UserVO userVO = new UserVO();
        ObjectId productId = ObjectId.get();
        ArrayList<Bet> bets = new ArrayList<>();

        when(conversionService.convert(user, UserVO.class)).thenReturn(userVO);

        Product product = new Product();
        product.setId(productId);
        product.setAddedDate(date);
        product.setValidDate(date);
        product.setCategory("phone");
        product.setDescription("simple description");
        product.setPrice(BigDecimal.TEN);
        product.setProductStatus(ProductStatus.VALID);
        product.setTitle("Title");
        product.setVersion(Long.valueOf(41));
        product.setOwner(user);
        product.setWinner(user);
        product.setBets(bets);

        ProductVO productVO = converter.convert(product);
        assertEquals(productId.toString(), productVO.getId());
        assertEquals(Long.valueOf(date.getTime()), productVO.getAddedDate());
        assertEquals(Long.valueOf(date.getTime()), productVO.getValidDate());
        assertEquals(userVO, productVO.getUser());
        assertEquals(userVO, productVO.getWinner());
        verify(conversionService, times(2)).convert(user, UserVO.class);
        assertEquals(Long.valueOf(41),productVO.getVersion());
        assertEquals("simple description", productVO.getDescription());
        assertEquals(BigDecimal.TEN, productVO.getPrice());
        assertEquals(ProductStatus.VALID.toString(), productVO.getProductStatus());
        assertEquals("Title", productVO.getTitle());
        assertEquals("phone", productVO.getCategory());
        assertEquals(bets, productVO.getBets());
    }

    @Test
    public void testConvertNullProduct2ProductVOShouldReturnNull(){
        Product product = null;
        ProductVO productVO = converter.convert(product);
        assertThat(productVO, is(nullValue()));

    }
}