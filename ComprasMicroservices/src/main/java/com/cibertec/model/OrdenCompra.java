package com.cibertec.model;

import java.time.LocalDate;

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
@Table(name = "Orden_Compra")
@Data
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Orden")
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "ID_Proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "Fecha_Orden")
    private LocalDate fechaOrden;

    @Column(name = "Estado")
    private String estado = "Pendiente";

    @Column(name = "Observaciones", columnDefinition = "TEXT")
    private String observaciones;
}