package com.java.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {
	
	public static void main(String[] args) {
		Loader.initDependencies();
		SpringApplication.run(BootApplication.class, args);
	}
}
