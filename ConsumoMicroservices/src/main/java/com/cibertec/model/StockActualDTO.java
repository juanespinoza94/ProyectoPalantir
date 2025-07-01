package com.cibertec.model;

import java.time.LocalDate;

public interface StockActualDTO {
    String getNombre();
    Integer getCantidadDisponible();
    LocalDate getFechaVencimiento();
}
