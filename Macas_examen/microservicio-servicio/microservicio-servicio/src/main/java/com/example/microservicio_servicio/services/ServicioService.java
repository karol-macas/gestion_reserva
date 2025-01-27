package com.example.microservicio_servicio.services;

import com.example.microservicio_servicio.models.entities.Servicio;
import com.example.microservicio_servicio.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    // Método para listar todos los servicios
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    // Método para guardar un servicio
    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    // Método para obtener un servicio por ID
    public Servicio obtenerServicioPorId(Long id) {
        Optional<Servicio> servicio = servicioRepository.findById(id);
        return servicio.orElse(null); // Devuelve null si no se encuentra
    }

    // Método para eliminar un servicio
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
