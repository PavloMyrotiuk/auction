package com.myrotiuk.auction.engine.service.job;

import com.myrotiuk.auction.engine.service.command.Command;
import com.myrotiuk.auction.engine.service.message.ProductCreatedMessageProcessor;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by pav on 3/22/15.
 */
public class CommandExecutorJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Command command = (Command)context.getMergedJobDataMap().get(ProductCreatedMessageProcessor.COMMAND);
        command.execute();
    }
}
