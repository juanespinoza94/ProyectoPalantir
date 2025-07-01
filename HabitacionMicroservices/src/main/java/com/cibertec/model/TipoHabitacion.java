package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Tipo_Habitacion")
@Data

public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tipo_Habitacion")
    private Long id;

    @Column(name = "Precio")
    private double precio;

    @Column(name = "Nombre" )
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Numero_Habitaciones")
    private int numeroHabitaciones;
}
