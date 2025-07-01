package com.cibertec.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.TipoHabitacion;


public interface TipoHabitacionService {
	
	public ResponseEntity<List<TipoHabitacion>> listarTipoHabitacion();
	public ResponseEntity<TipoHabitacion> agregarTipoHabitacion(TipoHabitacion tipohabitacion);
	public ResponseEntity<TipoHabitacion>  actualizarTipoHabitacion(TipoHabitacion tipohabitacion, Long id);

}
