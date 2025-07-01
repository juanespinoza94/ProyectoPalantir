package com.cibertec.controller;

import com.cibertec.model.Cargo;
import com.cibertec.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public ResponseEntity<List<Cargo>> listarCargos() {
        return cargoService.listarCargos();
    }

    @PostMapping
    public ResponseEntity<Cargo> agregarCargo(@RequestBody Cargo cargo) {
        return cargoService.agregarCargo(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> actualizarCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
        return cargoService.actualizarCargo(cargo, id);
    }

}
