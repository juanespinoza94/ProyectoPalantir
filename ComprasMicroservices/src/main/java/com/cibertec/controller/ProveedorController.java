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

import com.cibertec.model.Proveedor;
import com.cibertec.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService service;
	
	@GetMapping()
	public ResponseEntity<List<Proveedor>> listarTipoProveedor(){
		return service.listarProveedor( );
	}
	
	 @PostMapping
	    public ResponseEntity<Proveedor> createTipoHabitaicon(@RequestBody Proveedor proveedor) {
	        return service.agregarProveedor(proveedor);
	    }

	    
	 @PutMapping("/{id}") 
		public ResponseEntity <Proveedor> ActualizarTipoProveedor (@RequestBody Proveedor proveedor , @PathVariable Long id) {
			return service.actualizarProveedor(proveedor, id);
		}
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePago(@PathVariable Long id) {
	        service.eliminarProveedor(id);
	        return ResponseEntity.noContent().build();
	    }
}
