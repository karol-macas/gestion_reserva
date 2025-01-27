package com.example.microservicio_reserva.models.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Asegúrate de que el ID sea autoincrementable
    private Long id;

    private String nombre;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Equals y hashCode (para ManyToMany)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(id, servicio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
