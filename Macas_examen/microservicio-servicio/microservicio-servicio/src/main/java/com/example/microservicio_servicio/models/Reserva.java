package com.example.microservicio_servicio.models;

import com.example.microservicio_servicio.models.entities.Servicio;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private String fechaReserva;
    private String detalles;

    @ManyToMany
    @JoinTable(
            name = "reserva_servicio",  // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private List<Servicio> servicios;

    // Constructor vacío para JPA
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(String nombreCliente, String fechaReserva, String detalles) {
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.detalles = detalles;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    // Getters y setters para la relación ManyToMany
    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    // Método toString para mostrar los detalles de la reserva
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
