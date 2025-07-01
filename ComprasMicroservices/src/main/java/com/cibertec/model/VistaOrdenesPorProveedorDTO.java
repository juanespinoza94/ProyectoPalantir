package com.cibertec.model;

import java.time.LocalDate;

public interface VistaOrdenesPorProveedorDTO {

	Long getIdProveedor();
    String getProveedor();
    Long getIdOrden();
    LocalDate getFechaOrden();
    String getEstado();
    Double getTotalOrden();
}
