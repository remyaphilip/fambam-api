package com.fambam.api.fambamapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.fambam.api.repository"})
@ComponentScan(basePackages={"com.fambam.api"})
@EntityScan("com.fambam.api.model")
public class FambamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FambamApiApplication.class, args);
	}
}
