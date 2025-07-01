package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumoMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoMicroservicesApplication.class, args);
	}

}
