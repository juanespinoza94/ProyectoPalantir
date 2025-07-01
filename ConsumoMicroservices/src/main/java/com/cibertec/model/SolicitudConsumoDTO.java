package com.cibertec.model;

import java.time.LocalDateTime;

public interface SolicitudConsumoDTO {
    Integer getIdSolicitudConsumo();
    Integer getIdReserva();
    String getHuesped();
    String getItem();
    String getTipo();
    Integer getCantidad();
    String getEstado();
    LocalDateTime getFechaSolicitud();
    LocalDateTime getFechaAtencion();
}