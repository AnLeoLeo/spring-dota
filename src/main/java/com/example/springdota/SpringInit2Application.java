package com.example.springdota;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringInit2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringInit2Application.class, args);

		Backpack backpack = (Backpack) run.getBean("backpack");
		Hero hero = (Hero)run.getBean("hero");
		Backpack backpack2 = (Backpack) run.getBean("backpack");
		Hero hero2 = (Hero)run.getBean("hero");
		Backpack backpack3 = (Backpack) run.getBean("backpack");

		log.info(hero.toString());
		log.info(hero2.toString());
		log.info(backpack.toString());
		log.info(backpack2.toString());
		log.info(backpack3.toString());
	}

}
