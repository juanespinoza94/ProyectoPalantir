package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.Habitacion;


public interface HabitacionService {

	
	public ResponseEntity<List<Habitacion>> listarHabitacion();
	public ResponseEntity<Habitacion> agregarHabitacion(Habitacion habitacion);
	public ResponseEntity<List<Habitacion>> listarPorIdTipoYEstado(Long idTipoHabitacion, String estado);
	public ResponseEntity<Habitacion>  actualizarHabitacion(Habitacion habitacion, Long id);
	public ResponseEntity<?>  eliminarHabitacion(Long id);
}
