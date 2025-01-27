package com.example.microservicio_servicio.controllers;

import com.example.microservicio_servicio.models.entities.Servicio;
import com.example.microservicio_servicio.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public List<Servicio> listarServicios() {
        return servicioService.listarServicios();
    }

    @PostMapping
    public Servicio guardarServicio(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }

    @GetMapping("/{id}")
    public Servicio obtenerServicioPorId(@PathVariable Long id) {
        return servicioService.obtenerServicioPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarServicio(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}
