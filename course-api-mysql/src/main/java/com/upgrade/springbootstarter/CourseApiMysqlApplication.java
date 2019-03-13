package com.upgrade.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.upgrade.springbootstarter.*")
@EntityScan("com.upgrade.springbootstarter.*")
//@EnableAutoConfiguration
//@EnableJpaRepositories
@SpringBootApplication
public class CourseApiMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApiMysqlApplication.class, args);
	}

}
