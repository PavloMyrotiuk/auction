package com.myrotiuk.auction.engine.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by pav on 1/24/15.
 */
public class WebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = getRootApplicationContext();
        container.addListener(new ContextLoaderListener(rootContext));
    }

    private AnnotationConfigWebApplicationContext getRootApplicationContext(){
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.setConfigLocation("com.myrotiuk.auction.engine.config");
        return rootContext;
    }
}
