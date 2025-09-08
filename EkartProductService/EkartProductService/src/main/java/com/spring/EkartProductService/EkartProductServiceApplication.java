package com.spring.EkartProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EkartProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkartProductServiceApplication.class, args);
	}

}
