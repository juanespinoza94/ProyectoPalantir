package com.cibertec.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaUpdateDTO {
    private Integer cantidadHuespedes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Long habitacion;
}