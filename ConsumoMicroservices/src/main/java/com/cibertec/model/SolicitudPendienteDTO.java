package com.cibertec.model;

import lombok.Data;

import java.time.LocalDateTime;

public interface SolicitudPendienteDTO {
    Integer getIdSolicitudConsumo();
    String getHuesped();
    Integer getIdHabitacion();
    String getItem();
    String getTipo();
    Integer getCantidad();
    String getEstado();
    LocalDateTime getFechaSolicitud();
    String getObservaciones();
}
