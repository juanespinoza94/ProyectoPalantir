package com.cibertec.model;

public interface VistaCheckPendienteDTO {

	 Long getIdReserva();
	    String getHuesped();
	    java.time.LocalDate getFechaInicio();
	    java.time.LocalDate getFechaFin();
	    String getEstado();
}
