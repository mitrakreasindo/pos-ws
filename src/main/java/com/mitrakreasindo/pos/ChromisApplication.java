package com.mitrakreasindo.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.mitrakreasindo.pos")
@EntityScan(basePackages="com.mitrakreasindo.pos")
@ComponentScan(basePackages="com.mitrakreasindo.pos")
public class ChromisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChromisApplication.class, args);
	}
}
