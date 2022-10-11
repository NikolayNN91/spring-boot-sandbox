package com.sandbox.config;

import com.sandbox.config.condition.ConditionalOnOs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

@Configuration
public class OsLogSchedulerAutoconfiguration {

    @Bean
    public ThreadPoolTaskScheduler getScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler
                = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(2);
        threadPoolTaskScheduler.setThreadNamePrefix(
                "ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }

    @Bean
    @ConditionalOnOs("windows 10")
    public CronTrigger getCronTrigger() {
        return new CronTrigger("0 * * * * ?");
    }

    @Bean
    @ConditionalOnOs
    public CronTrigger getCronTrigger2() {
        return new CronTrigger("*/30 * * * * ?");
    }
}
