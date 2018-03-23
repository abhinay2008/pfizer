package com.pfizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.pfizer.repositories")
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class PfizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfizerApplication.class, args);
	}
}
