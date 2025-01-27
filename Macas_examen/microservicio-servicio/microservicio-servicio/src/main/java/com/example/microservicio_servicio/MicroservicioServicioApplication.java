package com.example.microservicio_servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class MicroservicioServicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioServicioApplication.class, args);
	}

}
