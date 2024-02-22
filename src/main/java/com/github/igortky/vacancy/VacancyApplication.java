package com.github.igortky.vacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.igortky")
public class VacancyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacancyApplication.class, args);
	}

}
