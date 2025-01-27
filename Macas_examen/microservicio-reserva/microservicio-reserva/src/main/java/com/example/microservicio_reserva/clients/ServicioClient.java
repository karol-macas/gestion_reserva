package com.example.microservicio_reserva.clients;

import com.example.microservicio_reserva.models.entities.Servicio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-servicio", url = "http://localhost:8081")
public interface ServicioClient {
    @GetMapping("/servicios/{id}")
    Servicio obtenerServicio(@PathVariable("id") Long servicioId);
}
