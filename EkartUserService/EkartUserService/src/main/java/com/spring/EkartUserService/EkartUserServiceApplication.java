package com.spring.EkartUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EkartUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartUserServiceApplication.class, args);
	}

}
