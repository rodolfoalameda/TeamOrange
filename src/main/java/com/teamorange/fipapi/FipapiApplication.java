package com.teamorange.fipapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FipapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FipapiApplication.class, args);
	}

}
