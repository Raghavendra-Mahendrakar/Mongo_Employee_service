package com.pws.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.pws.employee.utility.AuditAwareImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication 
@EnableJpaAuditing
@ComponentScan(basePackages = { "com.pws.employee*" })
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditAwareImpl();
	}

}
