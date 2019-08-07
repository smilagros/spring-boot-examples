package com.okta.developer.jugtours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class JugtoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(JugtoursApplication.class, args);
	}

}

