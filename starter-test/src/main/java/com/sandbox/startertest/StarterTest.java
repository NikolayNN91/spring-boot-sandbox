package com.sandbox.startertest;

import com.sandbox.startertest.service.StarterTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StarterTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(StarterTest.class, args);
        run.getBean(StarterTestService.class).runTask();
    }
}
