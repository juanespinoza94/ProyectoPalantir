package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.model.Habitacion;
import com.cibertec.service.HabitacionService;


@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {

	
	@Autowired
	private HabitacionService service;
	
	@GetMapping()
	public ResponseEntity<List<Habitacion>> listarTipoHabitacion(){

		return service.listarHabitacion( );
	}

	@GetMapping("/disponibles")
	public ResponseEntity<List<Habitacion>> listarDisponibles(@RequestParam Long idTipoHabitacion,
															  @RequestParam(defaultValue = "Disponible") String estado){
		return service.listarPorIdTipoYEstado(idTipoHabitacion,estado);
	}

	 @PostMapping
	    public ResponseEntity<Habitacion> createTipoHabitaicon(@RequestBody Habitacion habitacion) {
	        return service.agregarHabitacion(habitacion);
	    }

	    
	 @PutMapping("/{id}") 
		public ResponseEntity <Habitacion> ActualizarTipoHabitacion (@RequestBody Habitacion habitacion , @PathVariable Long id) {
			return service.actualizarHabitacion(habitacion, id);
		}
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePago(@PathVariable Long id) {
	        service.eliminarHabitacion(id);
	        return ResponseEntity.noContent().build();
	    }
}
