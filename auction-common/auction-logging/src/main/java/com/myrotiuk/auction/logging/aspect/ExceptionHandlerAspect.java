package com.myrotiuk.auction.logging.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by pav on 1/28/15.
 */
@Aspect
@Component
public class ExceptionHandlerAspect {

    Logger logger = LogManager.getLogger(ExceptionHandlerAspect.class);

    @AfterThrowing(pointcut = "within(com.myrotiuk.auction..*)", throwing = "exception")
    public void logAfterThrowingExceptionAndSubException(JoinPoint joinPoint, Exception exception) {

        logger.error("Method "+ joinPoint.getSignature().toString()+ " has thrown exception "+ exception);
        logger.error(getStackTrace(exception));

    }

    private static String getStackTrace(Throwable throwable){
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter  = new PrintWriter(stringWriter, true);
        throwable.printStackTrace(printWriter);
        return stringWriter.getBuffer().toString();
    }
}
