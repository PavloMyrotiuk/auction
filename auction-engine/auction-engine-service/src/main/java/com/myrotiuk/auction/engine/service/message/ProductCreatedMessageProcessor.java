package com.myrotiuk.auction.engine.service.message;

import com.myrotiuk.auction.common.core.message.ProductCreatedMessage;
import com.myrotiuk.auction.engine.service.annotation.ProductCreatedMessageProcessorQualifier;
import com.myrotiuk.auction.engine.service.command.Command;
import com.myrotiuk.auction.engine.service.command.CommandFactory;
import com.myrotiuk.auction.engine.service.job.CommandExecutorJob;
import org.bson.types.ObjectId;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pav on 3/15/15.
 */
@Component
@ProductCreatedMessageProcessorQualifier
public class ProductCreatedMessageProcessor implements MessageProcessor<ProductCreatedMessage> {
    public static final String COMMAND = "command";

    @Autowired
    private CommandFactory commandFactory;

    @Autowired
    SchedulerFactory schedulerFactory;

    @Override
    public void process(ProductCreatedMessage message) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            Command command = commandFactory.getUpdateProductStatusCommand(new ObjectId(message.getProductId()));

            JobDataMap jobDataMap = new JobDataMap(getJobDataMap(command));
            JobDetail jobDetail =  JobBuilder.newJob().
                    ofType(CommandExecutorJob.class).
                    setJobData(jobDataMap).
                    build();

            Date runTime = new Date(message.getValidDate());
            Trigger trigger = TriggerBuilder.newTrigger().
                    startAt(runTime).
                    build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Object> getJobDataMap(Command command) {
        Map<String, Object> jobDataMap = new HashMap<>();
        jobDataMap.put(COMMAND, command);
        return jobDataMap;
    }
}
