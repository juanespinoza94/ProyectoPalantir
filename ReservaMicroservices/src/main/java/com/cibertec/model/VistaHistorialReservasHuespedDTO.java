package com.cibertec.model;

public interface VistaHistorialReservasHuespedDTO {

	   Long getIdReserva();
	    String getHuesped();
	    java.time.LocalDate getFechaInicio();
	    java.time.LocalDate getFechaFin();
	    Integer getCantidadHuespedes();
	    String getEstadoReserva();
	    String getNumeroDocumento();
	    String getTipoHabitacion();
	    Double getPrecio();
	    Double getCostoTotal();
}
