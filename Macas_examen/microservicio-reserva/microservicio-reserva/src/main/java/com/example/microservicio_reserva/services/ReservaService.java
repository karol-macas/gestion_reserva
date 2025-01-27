package com.example.microservicio_reserva.services;

import com.example.microservicio_reserva.models.entities.Reserva;
import com.example.microservicio_reserva.models.entities.Servicio;

import java.util.List;

public interface ReservaService {
    // Asignar un servicio a una reserva
    Reserva asignarServicioAReserva(Long reservaId, Long servicioId);

    // Listar los servicios asociados a una reserva
    List<Servicio> listarServiciosDeReserva(Long reservaId);

    // Listar las reservas que incluyen un servicio específico
    List<Reserva> listarReservasPorServicio(Long servicioId);

    // Eliminar un servicio de una reserva
    Reserva eliminarServicioDeReserva(Long reservaId, Long servicioId);

    List<Reserva> listarReservas();

    Reserva guardarReserva(Reserva reserva);

    boolean eliminarReserva(Long reservaId);

    Reserva actualizarReserva(Long reservaId, Reserva reserva);
}
