package com.example.replay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReplayApplication.class, args);
	}

}
