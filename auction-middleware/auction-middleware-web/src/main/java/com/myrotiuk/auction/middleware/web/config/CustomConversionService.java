package com.myrotiuk.auction.middleware.web.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
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
        List<T> result = new ArrayList<>();
        for (Object elem : elems){
            result.add(convert(elem, targetType));
        }
        return result;
    }

    @Override
    public void addConverter(Converter<?, ?> converter) {
        super.addConverter(converter);
    }
}
