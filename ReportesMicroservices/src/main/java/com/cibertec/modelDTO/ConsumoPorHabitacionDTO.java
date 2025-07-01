package com.cibertec.modelDTO;

import java.time.LocalDateTime;

public interface ConsumoPorHabitacionDTO {
    Long getIdHabitacion();
    String getItem();
    String getTipo();
    Integer getCantidad();
    LocalDateTime getFechaSolicitud();
    String getEstado();
}
