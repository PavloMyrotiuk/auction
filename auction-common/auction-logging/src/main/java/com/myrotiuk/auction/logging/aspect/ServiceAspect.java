package com.myrotiuk.auction.logging.aspect;

import com.myrotiuk.auction.logging.aspect.helper.LoggingAspectHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Created by pav on 1/31/15.
 */
@Aspect
@Component
public class ServiceAspect {

    Logger logger = LogManager.getLogger(ServiceAspect.class);

    @Before("execution( * com.myrotiuk.auction.*.service.*.*(..))")
    public void logAuctionJmsServiceExecution(JoinPoint joinPoint){
        logger.trace(LoggingAspectHelper.getMethodExecutionMessage(joinPoint));
    }

}
