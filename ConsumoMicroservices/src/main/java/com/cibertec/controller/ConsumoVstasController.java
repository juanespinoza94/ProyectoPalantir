package com.cibertec.controller;

import com.cibertec.model.*;
import com.cibertec.service.ConsumoVistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consumoVistas")
public class ConsumoVstasController {
    @Autowired
    private ConsumoVistasService service;

    @GetMapping("/solicitudesConsumo")
    public ResponseEntity<List<SolicitudConsumoDTO>> listarSolicitudes() {
        return ResponseEntity.ok(service.listarVistasSolicitudes());
    }

    @GetMapping("/solicitudesPendientes")
    public ResponseEntity<List<SolicitudPendienteDTO>> listarSolicitudesPendientes() {
        return ResponseEntity.ok(service.listarVistasPendientes());
    }

    @GetMapping("/serviciosProgramados")
    public ResponseEntity<List<ServicioProgramadoDTO>> listarServiciosProgramados() {
        return ResponseEntity.ok(service.listarServiciosProgramados());
    }

    @GetMapping("/serviciosAsignados")
    public ResponseEntity<List<ServicioAsignadoDTO>> listarServiciosAsignados() {
        return ResponseEntity.ok(service.listarServiciosAsignados());
    }

    @GetMapping("/historialSolicitudesServicio")
    public ResponseEntity<List<HistorialSolicitudServicioDTO>> listarHistorialSolicitudes() {
        return ResponseEntity.ok(service.listarHistorialSolicitudesServicio());
    }
}

