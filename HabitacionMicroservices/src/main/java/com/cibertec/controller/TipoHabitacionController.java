package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.TipoHabitacion;
import com.cibertec.service.TipoHabitacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tipoHabitacion")
public class TipoHabitacionController {

	
	@Autowired
	private TipoHabitacionService service;
	
	@GetMapping()
	public ResponseEntity<List<TipoHabitacion>> listarTipoHabitacion(){
		return service.listarTipoHabitacion( );
	}
	
	 @PostMapping
	    public ResponseEntity<TipoHabitacion> createTipoHabitaicon(@RequestBody TipoHabitacion tipohabitacion) {
	        return service.agregarTipoHabitacion(tipohabitacion);
	    }

	    
	 @PutMapping("/{id}") 
		public ResponseEntity <TipoHabitacion> ActualizarTipoHabitacion (@RequestBody TipoHabitacion tipohabitacion , @PathVariable Long id) {
			return service.actualizarTipoHabitacion(tipohabitacion, id);
		}
	
}
