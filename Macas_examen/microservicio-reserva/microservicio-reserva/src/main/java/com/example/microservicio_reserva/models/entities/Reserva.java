package com.example.microservicio_reserva.models.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.List;


@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;

    @ManyToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "reserva_servicio", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "reserva_id"), // Columna que hace referencia a la entidad Reserva
            inverseJoinColumns = @JoinColumn(name = "servicio_id") // Columna que hace referencia a la entidad Servicio
    )
    private List<Servicio> servicios;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}