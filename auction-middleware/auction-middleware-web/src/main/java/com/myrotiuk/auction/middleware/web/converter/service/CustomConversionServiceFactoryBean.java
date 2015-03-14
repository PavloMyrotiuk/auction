package com.myrotiuk.auction.middleware.web.converter.service;

import com.myrotiuk.auction.middleware.web.converter.BetVO2BetConverter;
import com.myrotiuk.auction.middleware.web.converter.Category2CategoryVOConverter;
import com.myrotiuk.auction.middleware.web.converter.Product2ProductVOConverter;
import com.myrotiuk.auction.middleware.web.converter.ProductVO2ProductConverter;
import com.myrotiuk.auction.middleware.web.converter.String2ObjectIdConverter;
import com.myrotiuk.auction.middleware.web.converter.User2UserVOConverter;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/25/15.
 */
public class CustomConversionServiceFactoryBean extends ConversionServiceFactoryBean implements InitializingBean {

    @Autowired
    private Category2CategoryVOConverter category2CategoryVOConverter;

    @Autowired
    private Product2ProductVOConverter product2ProductVOConverter;

    @Autowired
    private ProductVO2ProductConverter productVO2ProductConverter;

    @Autowired
    private User2UserVOConverter user2UserVOConverter;

    @Autowired
    private String2ObjectIdConverter string2ObjectIdConverter;

    @Autowired
    private BetVO2BetConverter betVO2BetConverter;

    @Override
    protected CustomConversionService createConversionService() {
        CustomConversionService customConversionService = new CustomConversionService();
        addCustomConverters(customConversionService, getConverters());
        return customConversionService;
    }

    @Override
    public Class<? extends ConversionService> getObjectType() {
        return CustomConversionService.class;
    }

    private void addCustomConverters(CustomConversionService conversionService, Set<Converter> converters){
        for (Converter converter: converters){
            conversionService.addConverter(converter);
        }
    }

    private Set<Converter> getConverters() {
        Set<Converter> result = new HashSet<>();
        result.add(product2ProductVOConverter);
        result.add(productVO2ProductConverter);
        result.add(user2UserVOConverter);
        result.add(category2CategoryVOConverter);
        result.add(string2ObjectIdConverter);
        result.add(betVO2BetConverter);
        return result;
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        category2CategoryVOConverter.setCustomConversionService((CustomConversionService) this.getObject());
        product2ProductVOConverter.setConversionService(this.getObject());
    }
}
