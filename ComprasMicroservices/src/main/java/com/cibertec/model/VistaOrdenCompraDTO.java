package com.cibertec.model;

import java.time.LocalDate;

public interface VistaOrdenCompraDTO {

	 Long getIdOrden();
	   LocalDate getFechaOrden();
	   String getProveedor();
	   String getEstado();
	   String getObservaciones();
}
