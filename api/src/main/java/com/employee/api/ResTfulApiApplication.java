package com.employee.api;

import com.employee.api.faker.FakeCandidateFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ResTfulApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ResTfulApiApplication.class, args);
		context.getBean(FakeCandidateFactory.class).candidateGenerator();
	}
}
