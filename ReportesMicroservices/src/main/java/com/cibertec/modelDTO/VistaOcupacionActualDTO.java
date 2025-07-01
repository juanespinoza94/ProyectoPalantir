package com.cibertec.modelDTO;

import java.time.LocalDate;

public interface VistaOcupacionActualDTO {

    Long getIdReserva();
    Long getIdHabitacion();
    String getEstado();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getEstadoReserva();
    String getHuesped();
}
