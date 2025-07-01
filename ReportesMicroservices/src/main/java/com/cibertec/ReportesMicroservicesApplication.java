package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReportesMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportesMicroservicesApplication.class, args);
	}

}
