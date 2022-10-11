package com.sandbox.startertest.service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class StarterTestService {

    private ThreadPoolTaskScheduler scheduler;
    private CronTrigger cronTrigger;

    public StarterTestService(ThreadPoolTaskScheduler scheduler, CronTrigger cronTrigger) {
        this.scheduler = scheduler;
        this.cronTrigger = cronTrigger;
    }

    public void runTask() {
        scheduler.schedule(() -> System.out.println(Instant.now() + " I am working"), cronTrigger);
    }
}
