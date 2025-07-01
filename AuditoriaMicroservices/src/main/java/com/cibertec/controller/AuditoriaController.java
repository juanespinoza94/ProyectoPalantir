package com.cibertec.controller;

import com.cibertec.model.Auditoria;
import com.cibertec.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping
    public List<Auditoria> listar() {
        return auditoriaService.listar();
    }

    @PostMapping
    public ResponseEntity<Auditoria> guardar(@RequestBody Auditoria auditoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(auditoriaService.guardar(auditoria));
    }

    @GetMapping("/empleado/{id}")
    public List<Auditoria> porEmpleado(@PathVariable Long id) {
        return auditoriaService.buscarPorEmpleado(id);
    }

    @GetMapping("/tabla/{nombre}")
    public List<Auditoria> porTabla(@PathVariable String nombre) {
        return auditoriaService.buscarPorTabla(nombre);
    }

    @GetMapping("/{accion}")
    public List<Auditoria> porAccion(@PathVariable String accion) {
        return auditoriaService.buscarPorAccion(accion);
    }

    @GetMapping("/fecha")
    public List<Auditoria> porFechas(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin
    ) {
        return auditoriaService.buscarPorRangoFechas(inicio, fin);
    }
}

