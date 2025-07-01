package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Precio_Habitacion_Plan")
@Data
public class PrecioHabitacionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Precio_Plan")
    private Long id;

    @Column(name = "ID_Tipo_Habitacion")
    private Long idTipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "ID_Plan")
    private PlanAlojamiento planAlojamiento;

    @Column(name = "Precio")
    private BigDecimal precio;
}

