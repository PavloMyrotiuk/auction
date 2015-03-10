package com.myrotiuk.auction.middleware.web.converter;


import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 3/10/15.
 */
@Component
public class String2ObjectIdConverter implements Converter<String, ObjectId> {

    @Override
    public ObjectId convert(String source) {
        if (source == null ) return null;

        return new ObjectId(source);
    }
}
