package com.cibertec.model;

import java.time.LocalDate;


import java.math.BigDecimal;
import java.time.LocalDate;

public interface VistaReservasPendientes {

    Long getIdReserva();
    String getHuesped();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    String getEstadoReserva();
    BigDecimal getMontoPagado();
    BigDecimal getMontoPendiente();
}
