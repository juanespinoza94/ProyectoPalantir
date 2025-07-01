package com.cibertec.model;

public interface VistaReservasActivasDTO {

    Long getIdReserva();
    java.time.LocalDate getFechaInicio();
    java.time.LocalDate getFechaFin();
    String getEstado();
    Long getIdHabitacion();
    String getTipoHabitacion();
    String getHuesped();
}
