package com.cibertec.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaWebDTO {

    private Integer cantidadHuespedes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long habitacion;
    private Long huesped;
}

