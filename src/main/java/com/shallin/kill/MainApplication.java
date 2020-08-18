package com.shallin.kill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class MainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
}
