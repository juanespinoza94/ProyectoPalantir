package com.cibertec.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private Double precioVenta;
    private Integer cantidad;
    private LocalDate fechaVencimiento;
}