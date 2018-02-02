package com.employee.api;

import com.employee.api.faker.FakeCandidateFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class ResTfulApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ResTfulApiApplication.class, args);
		context.getBean(FakeCandidateFactory.class).candidateGenerator();

		//SpringApplication.run(ResTfulApiApplication.class, args);
	}
}
