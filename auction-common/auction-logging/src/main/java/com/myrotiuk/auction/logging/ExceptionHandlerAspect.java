package com.myrotiuk.auction.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;

/**
 * Created by pav on 1/26/15.
 */
@Aspect
public class ExceptionHandlerAspect {

    @PostConstruct
    public void init(){
        logger.trace("created ExceptionHandlerAspect");
        System.out.println("created ExceptionHandlerAspect");
    }

    Logger logger = LogManager.getLogger(ExceptionHandlerAspect.class);

    @AfterThrowing(pointcut = "within(com.myrotiuk.auction..*)", throwing = "exception")
    public void logAfterThrowingExceptionAndSubException(JoinPoint joinPoint, Exception exception) {

        logger.trace("logAfterThrowing() is running!");
        logger.debug("hijacked : " + joinPoint.getSignature().getName());
        logger.error("Exception : " + exception);
        logger.trace("******");

    }
}
