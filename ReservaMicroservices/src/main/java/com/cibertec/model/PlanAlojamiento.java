package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Plan_Alojamiento")
@Data
public class PlanAlojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Plan")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Duracion_Dias")
    private Integer duracionDias;

    @Column(name = "Incluye_Desayuno")
    private Boolean incluyeDesayuno = false;

    @Column(name = "Incluye_Bebidas")
    private Boolean incluyeBebidas = false;

    @Column(name = "Estado")
    private String estado = "Activo";
}
