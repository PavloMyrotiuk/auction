package com.myrotiuk.auction.common.logging.aspect.helper;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * Created by pav on 2/1/15.
 */
public class LoggingAspectHelper {

    public static String getMethodExecutionMessage(JoinPoint joinPoint){
        return "Method " + joinPoint.getSignature().toShortString() + " is called with parameters "+ Arrays.toString(joinPoint.getArgs());
    }
}
