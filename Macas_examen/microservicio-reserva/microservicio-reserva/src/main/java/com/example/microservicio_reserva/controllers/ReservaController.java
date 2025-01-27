package com.example.microservicio_reserva.controllers;

import com.example.microservicio_reserva.models.entities.Reserva;
import com.example.microservicio_reserva.models.entities.Servicio;
import com.example.microservicio_reserva.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Listar todas las reservas
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    // Guardar una nueva reserva
    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    // Asignar un servicio a una reserva

    @PostMapping("/{reservaId}/servicios/{servicioId}")
    public ResponseEntity<?> asignarServicioAReserva(@PathVariable Long reservaId, @PathVariable Long servicioId) {
        try {
            Reserva reserva = reservaService.asignarServicioAReserva(reservaId, servicioId);
            return ResponseEntity.ok(reserva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    // Listar los servicios asociados a una reserva
    @GetMapping("/{reservaId}/servicios")
    public List<Servicio> listarServiciosDeReserva(@PathVariable Long reservaId) {
        return reservaService.listarServiciosDeReserva(reservaId);
    }

    // Listar las reservas que incluyen un servicio específico
    @GetMapping("/servicios/{servicioId}/reservas")
    public List<Reserva> listarReservasPorServicio(@PathVariable Long servicioId) {
        return reservaService.listarReservasPorServicio(servicioId);
    }

    // Eliminar un servicio de una reserva
    @DeleteMapping("/{reservaId}/servicios/{servicioId}")
    public Reserva eliminarServicioDeReserva(@PathVariable Long reservaId, @PathVariable Long servicioId) {
        return reservaService.eliminarServicioDeReserva(reservaId, servicioId);
    }
}
