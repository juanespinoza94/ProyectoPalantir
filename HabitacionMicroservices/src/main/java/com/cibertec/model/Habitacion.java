package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Habitacion")
@Data

public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Habitacion")
    private Long id;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Estado")
    private String estado = "Disponible";

    // RELACIÓN MANY-TO-ONE -> TipoHabitacion
    @ManyToOne
    @JoinColumn(name = "ID_Tipo_Habitacion")
    private TipoHabitacion tipoHabitacion;
}