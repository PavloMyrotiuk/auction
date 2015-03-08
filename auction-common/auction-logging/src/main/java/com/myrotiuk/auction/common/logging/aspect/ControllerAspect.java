package com.myrotiuk.auction.common.logging.aspect;

import com.myrotiuk.auction.common.logging.aspect.helper.LoggingAspectHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by pav on 2/1/15.
 */
@Aspect
@Component
public class ControllerAspect {

    Logger logger = LogManager.getLogger(ControllerAspect.class);

    @Before("execution(* com.myrotiuk.auction.*.web.controller.*.*(..))")
    public void logControllerRequests(JoinPoint joinPoint){
        logger.debug(LoggingAspectHelper.getMethodExecutionMessage(joinPoint));
    }
}
