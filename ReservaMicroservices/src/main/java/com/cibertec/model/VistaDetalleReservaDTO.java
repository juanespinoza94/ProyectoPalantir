package com.cibertec.model;

public interface VistaDetalleReservaDTO {

	   Long getIdReserva();
	    String getNombreHuesped();
	    String getNumeroDocumento();
	    java.time.LocalDate getFechaInicio();
	    java.time.LocalDate getFechaFin();
	    Integer getCantidadHuespedes();
	    String getEstadoReserva();
	    Long getIdEmpleado();
	    String getTipoHabitacion();
	    Double getPrecio();
	    Double getCostoTotal();
	}

