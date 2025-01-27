package com.example.microservicio_reserva.services;

import com.example.microservicio_reserva.clients.ServicioClient;
import com.example.microservicio_reserva.models.entities.Reserva;
import com.example.microservicio_reserva.models.entities.Servicio;
import com.example.microservicio_reserva.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final ServicioClient servicioClient;

    public ReservaServiceImpl(ReservaRepository reservaRepository, ServicioClient servicioClient) {
        this.reservaRepository = reservaRepository;
        this.servicioClient = servicioClient;
    }

    @Override
    public Reserva asignarServicioAReserva(Long reservaId, Long servicioId) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(reservaId);

        if (!reservaOptional.isPresent()) {
            throw new IllegalArgumentException("Reserva no encontrada");
        }

        // Obtener servicio usando Feign Client
        Servicio servicio = servicioClient.obtenerServicio(servicioId);

        if (servicio == null) {
            throw new IllegalArgumentException("Servicio no encontrado");
        }

        Reserva reserva = reservaOptional.get();
        reserva.getServicios().add(servicio);
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Servicio> listarServiciosDeReserva(Long reservaId) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(reservaId);

        if (!reservaOptional.isPresent()) {
            throw new IllegalArgumentException("Reserva no encontrada");
        }

        return reservaOptional.get().getServicios();
    }

    @Override
    public List<Reserva> listarReservasPorServicio(Long servicioId) {
        return reservaRepository.findByServiciosId(servicioId);
    }

    @Override
    public Reserva eliminarServicioDeReserva(Long reservaId, Long servicioId) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(reservaId);

        if (!reservaOptional.isPresent()) {
            throw new IllegalArgumentException("Reserva no encontrada");
        }

        Reserva reserva = reservaOptional.get();
        boolean removed = reserva.getServicios().removeIf(servicio -> servicio.getId().equals(servicioId));

        if (!removed) {
            throw new IllegalArgumentException("Servicio no encontrado en la reserva");
        }

        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva guardarReserva(Reserva reserva) {
        if (reserva.getFecha() == null || reserva.getFecha().isEmpty()) {
            throw new IllegalArgumentException("La fecha no puede estar vacía");
        }
        return reservaRepository.save(reserva);
    }


    @Override
    public boolean eliminarReserva(Long reservaId) {
        if (reservaRepository.existsById(reservaId)) {
            reservaRepository.deleteById(reservaId);
            return true;
        }
        return false;
    }

    @Override
    public Reserva actualizarReserva(Long reservaId, Reserva reserva) {
        if (reservaRepository.existsById(reservaId)) {
            reserva.setId(reservaId);
            return reservaRepository.save(reserva);
        }
        throw new IllegalArgumentException("Reserva no encontrada");
    }

}
