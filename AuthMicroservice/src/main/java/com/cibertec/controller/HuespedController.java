package com.cibertec.controller;

import com.cibertec.model.Huesped;
import com.cibertec.repository.HuespedRepository;
import com.cibertec.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {

    @Autowired
    private HuespedService huespedService;

    @Autowired
    private HuespedRepository huespedRepository;

    @GetMapping
    public ResponseEntity<List<Huesped>> listarHuespedes() {
        return huespedService.listarHuespedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huesped> obtenerHuespedPorId(@PathVariable Long id) {
        Optional<Huesped> huesped = huespedRepository.findById(id);
        return huesped
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Huesped> obtenerPorNumeroDocumento(@PathVariable String numeroDocumento) {
        return huespedService.getHuespedPorNumeroDocumento(numeroDocumento);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Huesped>> listarPorEstado(@PathVariable String estado) {
        return huespedService.listarHuespedesporEstado(estado);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Long> obtenerIdHuespedPorUsuario(@PathVariable Long idUsuario) {
        Optional<Huesped> huesped = huespedRepository.findByUsuarioId(idUsuario);
        return huesped.map(h -> ResponseEntity.ok(h.getId()))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Huesped> agregarHuesped(@RequestBody Huesped huesped) {
        return huespedService.agregarHuesped(huesped);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Huesped> actualizarHuesped(@PathVariable Long id, @RequestBody Huesped huesped) {
        return huespedService.actualizarHuesped(huesped, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHuesped(@PathVariable Long id) {
        return huespedService.eliminarHuesped(id);
    }
}
