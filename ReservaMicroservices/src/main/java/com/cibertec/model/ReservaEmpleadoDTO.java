package com.cibertec.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservaEmpleadoDTO {


    private Integer cantidadHuespedes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long habitacion;
    private Long huesped;

    private Long empleado;
}
