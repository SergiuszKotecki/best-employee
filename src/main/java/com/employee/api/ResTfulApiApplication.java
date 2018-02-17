package com.employee.api;

import com.employee.api.faker.FakeCandidateFactory;
import com.employee.api.model.Role;
import com.employee.api.model.enums.RoleEnum;
import com.employee.api.service.CandidateService;
import com.employee.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class ResTfulApiApplication {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private RoleService roleService;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ResTfulApiApplication.class, args);
        context.getBean(FakeCandidateFactory.class).candidateGenerator();

        //SpringApplication.run(ResTfulApiApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {

            roleService.createRoleIfNotFound(RoleEnum.ADMIN);
            roleService.createRoleIfNotFound(RoleEnum.CANDIDATE);
            roleService.createRoleIfNotFound(RoleEnum.RECRUITER);

        };
    }


}
