package com.cibertec.controller;

import com.cibertec.model.BancoDisponible;
import com.cibertec.service.BancoDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bancoDisponibles")
public class BancoDisponibleController {

    @Autowired
    private BancoDisponibleService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoDisponible>> listar() {
        return bancoService.listarBancoDisponible();
    }

    @PostMapping
    public ResponseEntity<BancoDisponible> crear(@RequestBody BancoDisponible banco) {
        return bancoService.AgregarBancoDisponible(banco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BancoDisponible> actualizar(@PathVariable Long id, @RequestBody BancoDisponible banco) {
        return bancoService.ActualizarBancoDisponible(banco, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        return bancoService.EliminarBancoDisponible(id);
    }
}
