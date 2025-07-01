package com.cibertec.model;

import java.time.LocalDateTime;

public interface HistorialSolicitudServicioDTO {
    Integer getIdSolicitudConsumo();
    String getHuesped();
    String getItem();
    String getTipo();
    LocalDateTime getFechaSolicitud();
    LocalDateTime getFechaAtencion();
    String getEstado();
}
