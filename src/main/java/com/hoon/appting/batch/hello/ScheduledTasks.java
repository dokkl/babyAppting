package com.hoon.appting.batch.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hoon on 2015-07-24.
 */
@Component
public class ScheduledTasks {
    static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importUserJob;

    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 */1 * * * *") //1분마다
    public void reportCurrentTime() throws BeansException, JobExecutionAlreadyRunningException, org.springframework.batch.core.repository.JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException, InterruptedException {

        log.debug("The time is now " + dateFormat.format(new Date()));

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(importUserJob, jobParameters);
        BatchStatus batchStatus = jobExecution.getStatus();
        while(batchStatus.isRunning()){
            log.debug("*********** Still running.... **************");
            Thread.sleep(1000);
        }
    }
}
