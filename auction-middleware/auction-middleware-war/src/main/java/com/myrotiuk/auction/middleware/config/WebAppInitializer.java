package com.myrotiuk.auction.middleware.config;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by pav on 1/24/15.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/rest/*"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new DelegatingFilterProxy("springSecurityFilterChain")};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MiddlewareConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }
}
