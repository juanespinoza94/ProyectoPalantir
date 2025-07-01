package com.cibertec.model;

import java.time.LocalDateTime;

public interface ServicioAsignadoDTO {
    Integer getIdEmpleadoServicio();
    Integer getIdEmpleado();
    String getEmpleado();
    Integer getIdSolicitudConsumo();
    String getServicio();
    Integer getCantidad();
    String getEstado();
    LocalDateTime getFechaSolicitud();
}
