package com.cibertec.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Reserva")
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Reserva")
    private Long id;

    @Column(name = "Cantidad_Huespedes")
    private Integer cantidadHuespedes;

    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;

    @Column(name = "Fecha_Fin")
    private LocalDate fechaFin;

    @Column(name = "Estado")
    private String estado = "Pendiente";

    @Enumerated(EnumType.STRING)
    @Column(name = "Origen_Reserva")
    private OrigenReserva origenReserva = OrigenReserva.Web;

    // Relaciones con otras entidades

    @Column(name = "ID_Empleado")
    private Long empleado;

    @Column(name = "ID_Habitacion")
    private Long habitacion;

    
    @Column(name = "ID_Huesped")
    private Long huesped;

    // Enum para el origen de la reserva
    public enum OrigenReserva {
        Web,
        Empleado
    }
}
