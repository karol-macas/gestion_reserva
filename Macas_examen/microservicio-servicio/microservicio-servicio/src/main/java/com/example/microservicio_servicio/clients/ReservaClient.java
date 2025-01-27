package com.example.microservicio_servicio.clients;

import com.example.microservicio_servicio.models.Reserva; // Asegúrate de que este modelo esté bien definido
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-reserva", url = "http://localhost:8081")
public interface ReservaClient {

    @GetMapping("/reservas/{id}")
    Reserva obtenerReservaPorId(@PathVariable("id") Long id);
}
