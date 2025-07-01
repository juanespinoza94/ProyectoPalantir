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

import com.cibertec.model.OrdenCompra;
import com.cibertec.service.OrdenCompraService;

@RestController
@RequestMapping("/api/ordenCompra")
public class OrdenCompraController {

	@Autowired
	private OrdenCompraService service;
	
	@GetMapping()
	public ResponseEntity<List<OrdenCompra>> listarTipoOrdenCompra(){
		return service.listarOrdenCompra( );
	}
	
	 @PostMapping
	    public ResponseEntity<OrdenCompra> createTipoHabitaicon(@RequestBody OrdenCompra ordencompra) {
	        return service.agregarOrdenCompra(ordencompra);
	    }

	    
	 @PutMapping("/{id}") 
		public ResponseEntity <OrdenCompra> ActualizarTipoOrdenCompra (@RequestBody OrdenCompra ordencompra , @PathVariable Long id) {
			return service.actualizarOrdenCompra(ordencompra, id);
		}
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePago(@PathVariable Long id) {
	        service.eliminarOrdenCompra(id);
	        return ResponseEntity.noContent().build();
	    }
}
