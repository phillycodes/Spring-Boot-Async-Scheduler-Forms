package com.practice.async_scheduler_forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/*
* Author: Phillycodes
* Date: 07/24/2024
* Description: Program will run asynchronous tasks using Spring Boot. It will run scheduled tasks at a fixed rate and fixed delay.
* The application will also set up forms using the Thymeleaf template engine and perform built-in validation on the form fields.
* I also learned how to configure handler mappings in Spring MVC for request paths, extract request parameters and path variables,
* and run asynchronous and scheduled operations in Spring Boot. Finally, I learned how to perform validation of user-specified form inputs.
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsyncSchedulerFormsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncSchedulerFormsApplication.class, args);
	}

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("GithubLookup-");
		executor.initialize();

		return executor;
	}

}
