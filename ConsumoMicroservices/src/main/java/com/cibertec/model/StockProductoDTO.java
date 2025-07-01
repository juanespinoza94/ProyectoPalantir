package com.cibertec.model;

import java.time.LocalDateTime;

public interface StockProductoDTO {
    Integer getIdItemConsumo();
    String getNombre();
    Integer getCantidadDisponible();
    LocalDateTime getFechaUltimaActualizacion();
}
