package com.example.microservicio_reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroservicioReservaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioReservaApplication.class, args);
	}

}


