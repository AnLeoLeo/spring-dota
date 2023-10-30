package com.example.springdota;

import com.example.springdota.component.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringInit2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringInit2Application.class, args);
		run.getBean(Hero.class);
	}
}
