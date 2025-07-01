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

import com.cibertec.model.SolicitudConsumo;
import com.cibertec.service.SolicitudConsumoService;

@RestController
@RequestMapping("api/solicitudConsumo")
public class SolicitudConsumoController {

	@Autowired
	private SolicitudConsumoService solicitudConsumoService;
	
	@GetMapping
    public ResponseEntity<List<SolicitudConsumo>> listarSolicitudConsumos() {
        return solicitudConsumoService.listarSolicitudConsumo();
    }

    @PostMapping
    public ResponseEntity<SolicitudConsumo> createSolicitudConsumo(@RequestBody SolicitudConsumo solicitudConsumo) {
        return solicitudConsumoService.agregarSolicitudConsumo(solicitudConsumo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolicitudConsumo(@PathVariable Long id) {
    	solicitudConsumoService.eliminarSolicitudConsumo(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}") 
	public ResponseEntity <SolicitudConsumo> actualizarItemConsumo (@RequestBody SolicitudConsumo solicitudConsumo, @PathVariable Long id) {
		return solicitudConsumoService.editarSolicitudConsumo(solicitudConsumo, id);
	}
	
}
