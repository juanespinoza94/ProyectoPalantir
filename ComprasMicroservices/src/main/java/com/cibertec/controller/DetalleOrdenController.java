package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.DetalleOrden;
import com.cibertec.service.DetalleOrdenService;

@RestController
@RequestMapping("/api/detalleOrden")
public class DetalleOrdenController {

	@Autowired
	private DetalleOrdenService service;
	
	@GetMapping()
	public ResponseEntity<List<DetalleOrden>> listarTipoDetalleOrden(){
		return service.listarDetalleOrden( );
	}
	
	 @PostMapping
	    public ResponseEntity<DetalleOrden> createTipoHabitaicon(@RequestBody DetalleOrden detalleorden) {
	        return service.agregarDetalleOrden(detalleorden);
	    }

	    
	 @PutMapping("/{id}") 
		public ResponseEntity <DetalleOrden> ActualizarTipoDetalleOrden (@RequestBody DetalleOrden detalleorden , @PathVariable Long id) {
			return service.actualizarDetalleOrden(detalleorden, id);
		}
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePago(@PathVariable Long id) {
	        service.eliminarDetalleOrden(id);
	        return ResponseEntity.noContent().build();
	    }
}
