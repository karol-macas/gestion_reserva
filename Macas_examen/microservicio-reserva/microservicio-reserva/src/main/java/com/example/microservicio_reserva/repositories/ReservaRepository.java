package com.example.microservicio_reserva.repositories;

import com.example.microservicio_reserva.models.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Suponiendo que tienes una relación entre Reserva y Servicio
    List<Reserva> findByServiciosId(Long servicioId);  // Método para obtener reservas por servicio
}
