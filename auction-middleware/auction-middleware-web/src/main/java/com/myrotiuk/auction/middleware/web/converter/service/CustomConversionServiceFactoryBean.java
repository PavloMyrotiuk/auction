package com.myrotiuk.auction.middleware.web.converter.service;

import com.myrotiuk.auction.middleware.web.converter.Category2CategoryVOConverter;
import com.myrotiuk.auction.middleware.web.converter.Product2ProductVOConverter;
import com.myrotiuk.auction.middleware.web.converter.User2UserVOConverter;
import com.myrotiuk.auction.middleware.web.converter.service.CustomConversionService;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pav on 2/25/15.
 */
public class CustomConversionServiceFactoryBean extends ConversionServiceFactoryBean {

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
        result.add(new Product2ProductVOConverter());
        result.add(new User2UserVOConverter());
        result.add(new Category2CategoryVOConverter());
        return result;
    }

}
