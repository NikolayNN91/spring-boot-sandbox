package com.sandbox.startertest.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private ThreadPoolTaskScheduler scheduler;
    private CronTrigger cronTrigger;

    public CommandLineRunnerImpl(ThreadPoolTaskScheduler scheduler, CronTrigger cronTrigger) {
        this.scheduler = scheduler;
        this.cronTrigger = cronTrigger;
    }

    @Override
    public void run(String... args) throws Exception {
        scheduler.schedule(() -> System.out.println(Instant.now() + " I am working"), cronTrigger);
    }
}
