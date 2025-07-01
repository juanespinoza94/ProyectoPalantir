package com.cibertec.model;

import java.time.LocalDate;

public interface ProductoVencimientoDTO {
    Integer getIdItemConsumo();
    String getNombre();
    LocalDate getFechaVencimiento();
    Integer getDiasRestantes();
}
