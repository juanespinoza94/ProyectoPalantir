package com.cibertec.controller;

import com.cibertec.model.PagoDetalle;
import com.cibertec.service.PagoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagoDetalle")
public class PagoDetalleController {
    @Autowired
    private PagoDetalleService pagoDetalleService;

    @GetMapping
    public ResponseEntity<List<PagoDetalle>> listarPagoDetalle() {
        return pagoDetalleService.listarPagoDetalle();
    }

    @PostMapping
    public ResponseEntity<PagoDetalle> agregarPagoDetalle(@RequestBody PagoDetalle pagoDetalle) {
        return pagoDetalleService.AgregarPagoDetalle(pagoDetalle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPagoDetalle(@PathVariable long id) {
        return  pagoDetalleService.EliminarPagoDetalle(id);
    }
}
