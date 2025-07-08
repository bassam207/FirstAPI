package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@ComponentScan(basePackages = "com.example.demo")

@SpringBootApplication
@EnableJpaRepositories(
		basePackages = "com.example.demo",
		excludeFilters = @ComponentScan.Filter(
				type = org.springframework.context.annotation.FilterType.REGEX,
				pattern = "com\\.example\\.demo\\.Prescription\\..*"
		)
)
@RestController
public class FirstAPI {

	public static void main(String[] args) {
		/*var ctx = SpringApplication.run(FirstAPI.class,args);

		PatientService patientService = ctx.getBean(PatientService.class);
		System.out.println(patientService.getjavaversion());*/
		SpringApplication.run(FirstAPI.class, args);
	}



}