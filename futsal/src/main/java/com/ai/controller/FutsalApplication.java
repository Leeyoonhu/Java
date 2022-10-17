package com.ai.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ai.repository.FieldRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.controller", "com.ai.domain", "com.ai.repository", "com.ai.service"})
@EnableMongoRepositories(basePackageClasses = FieldRepository.class)
public class FutsalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutsalApplication.class, args);
	}

}
