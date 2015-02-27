package com.myrotiuk.auction.middleware.web.converter.service;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pav on 2/25/15.
 */
public class CustomConversionService extends DefaultConversionService {

    public <T> List<T> convertAll(List<?> elems, Class<T> targetType){

        Assert.notNull(targetType, "The targetType to convert to cannot be null");
        if (elems == null) return null;

        List<T> result = new ArrayList<>();
        for (Object elem : elems){
            result.add(convert(elem, targetType));
        }
        return result;
    }
}
