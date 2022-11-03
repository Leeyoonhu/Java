package com.ai.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ai.repository.FieldRepository;
import com.ai.repository.MemberRepository;
import com.ai.repository.ReserveListRepository;
import com.ai.repository.ReserveRepository;
//import com.ai.repository.ReserveRepository;
import com.ai.repository.TeamRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.controller", "com.ai.domain", "com.ai.repository", "com.ai.service", "com.ai.configuration"})
@EnableMongoRepositories(basePackageClasses = { FieldRepository.class, TeamRepository.class,
		MemberRepository.class, ReserveRepository.class, ReserveListRepository.class})
public class FutsalApplication extends SpringBootServletInitializer {
	
	// 외장 톰캣 Initializer
//	@Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(FutsalApplication.class);
//    }

	public static void main(String[] args) {
		SpringApplication.run(FutsalApplication.class, args);
	}

}
