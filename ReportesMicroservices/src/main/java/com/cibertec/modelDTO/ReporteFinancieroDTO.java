package com.cibertec.modelDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ReporteFinancieroDTO {
    Long getIdPago();
    LocalDateTime getFechaPago();
    String getMetodoPago();
    BigDecimal getMonto();
    Long getIdReserva();
    String getHuesped();
}
