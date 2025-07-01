package com.cibertec.controller;

import com.cibertec.model.PagoTarjeta;
import com.cibertec.service.PagoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagoTarjeta")
public class PagoTarjetaController {

    @Autowired
    private PagoTarjetaService pagoTarjetaService;

    @GetMapping
    public ResponseEntity<List<PagoTarjeta>> listarPagoTarjeta() {
        return pagoTarjetaService.listarPagoTarjeta();
    }

    @PostMapping
    public ResponseEntity<PagoTarjeta> agregarPagoTarjeta(@RequestBody PagoTarjeta pagoTarjeta) {
        return pagoTarjetaService.AgregarPagoTarjeta(pagoTarjeta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPagoTarjeta(@PathVariable long id) {
        return pagoTarjetaService.EliminarPagoTarjeta(id);
    }
}
