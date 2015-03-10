package com.myrotiuk.auction.middleware.web.converter;

import org.bson.types.ObjectId;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class String2ObjectIdConverterTest {


    private static String2ObjectIdConverter converter;

    @BeforeClass
    public static void init(){
        converter = new String2ObjectIdConverter();
    }

    @Test
    public void testConvertValidString2ObjectIdResultToStringShouldReturnGivenStringValue(){
        ObjectId rawId = ObjectId.get();
        String id = rawId.toString();

        ObjectId result = converter.convert(id);
        assertEquals(id, result.toString());
    }

    @Test
    public void testConvertNullString2ObjectIdResultShouldBeNull(){
        String id = null;

        ObjectId result = converter.convert(id);
        assertThat(result, is(nullValue()));
    }
}