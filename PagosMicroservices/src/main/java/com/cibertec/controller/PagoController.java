package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Pago;
import com.cibertec.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private  PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        return pagoService.listarPagos();
    }

    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        return pagoService.agregarPago(pago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePago(@PathVariable Long id) {
        return pagoService.eliminarPago(id);
    }
}
