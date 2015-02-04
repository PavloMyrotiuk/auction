package com.myrotiuk.auction.middleware.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by pav on 1/24/15.
 */
public class WebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = getRootApplicationContext();
        container.addListener(new ContextLoaderListener(rootContext));
        configureDispatcherServlet(container, rootContext);
    }

    private void configureDispatcherServlet(ServletContext container, AnnotationConfigWebApplicationContext rootContext) {
        ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    private AnnotationConfigWebApplicationContext getRootApplicationContext(){
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.setConfigLocation("com.myrotiuk.auction.middleware.config");
        return rootContext;
    }
}
