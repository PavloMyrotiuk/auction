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
public class JmsMessageAspect {

    Logger logger = LogManager.getLogger(JmsMessageAspect.class);

    @Before("execution( * com.myrotiuk.auction.jms.service.*.*(..))")
    public void logAuctionJmsServiceExecution(JoinPoint joinPoint){
        logger.debug(LoggingAspectHelper.getMethodExecutionMessage(joinPoint));
    }

}
