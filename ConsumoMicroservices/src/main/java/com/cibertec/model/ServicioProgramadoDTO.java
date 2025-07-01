package com.cibertec.model;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ServicioProgramadoDTO {
    Integer getIdHorarioServicio();
    Integer getIdSolicitudConsumo();
    String getServicio();
    LocalDate getFecha();
    LocalTime getHoraInicio();
    LocalTime getHoraFin();
    String getHuesped();
    Integer getIdHabitacion();
}
