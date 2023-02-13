package com.fintech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OpenApiSpecificationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenApiSpecificationDemoApplication.class, args);
	}

}
