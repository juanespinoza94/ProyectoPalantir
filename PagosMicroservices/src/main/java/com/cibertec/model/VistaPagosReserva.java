package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public interface VistaPagosReserva {

    Long getIdPago();
    LocalDateTime getFechaPago();
    BigDecimal getMonto();
    String getEstadoPago();
    String getMetodoPago();
    Long getIdReserva();
    BigDecimal getMontoPagado();

}
