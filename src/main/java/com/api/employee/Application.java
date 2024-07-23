package com.api.employee;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.api.employee"})
//@EnableJpaRepositories(basePackages = "com.api.employee.repository")
//@EntityScan(basePackages = "com.api.employee.entity")
public class Application {

	public static void main(String[] args) {

			SpringApplication.run(Application.class, args);
		}
}
