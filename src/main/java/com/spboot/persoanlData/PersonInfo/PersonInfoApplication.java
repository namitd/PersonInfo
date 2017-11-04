package com.spboot.persoanlData.PersonInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.spboot.persoanlData"})
public class PersonInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonInfoApplication.class, args);
	}
}
