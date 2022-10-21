package com.ai.controller;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ai.repository.FieldRepository;
import com.ai.repository.MemberRepository;
import com.ai.repository.TeamRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.controller", "com.ai.domain", "com.ai.repository", "com.ai.service", "com.ai.configuration"})
@EnableMongoRepositories(basePackageClasses = {FieldRepository.class, TeamRepository.class, MemberRepository.class}) // ReserveRepository})
public class FutsalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutsalApplication.class, args);
	}

}
