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

import com.cibertec.model.Stock;
import com.cibertec.model.VencimientoProducto;
import com.cibertec.service.VencimientoProductoService;

@RestController
@RequestMapping("/api/vencimientoProducto")
public class VencimientoProductoController {
	
	@Autowired
	private VencimientoProductoService vencimientoProductoService;
	
	@GetMapping
    public ResponseEntity<List<VencimientoProducto>> listarVencimiento() {
        return vencimientoProductoService.listarVencimientoProducto();
    }

    @PostMapping
    public ResponseEntity<VencimientoProducto> crearVencimiento(@RequestBody VencimientoProducto vencimientoProducto) {
        return vencimientoProductoService.agregarVencimientoProducto(vencimientoProducto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVencimiento(@PathVariable Long id) {
        vencimientoProductoService.eliminarVencimientoProducto(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("/{id}") 
	public ResponseEntity <VencimientoProducto> actualizarVencimientoProducto(@RequestBody VencimientoProducto vencimientoProducto, @PathVariable Long id) {
		return vencimientoProductoService.editarVencimientoProducto(vencimientoProducto, id);
	}
	
}
