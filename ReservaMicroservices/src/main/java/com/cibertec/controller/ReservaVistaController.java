package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cibertec.model.VistaDisponibilidadHabitacionDTO;
import com.cibertec.model.VistaHistorialReservasHuespedDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesDTO;
import com.cibertec.model.VistaReservasActivasDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesRecepcionistaDTO;
import com.cibertec.model.VistaCheckPendienteDTO;
import com.cibertec.model.VistaDetalleReservaDTO;
import com.cibertec.service.ReservaVistaService;

@RestController
@RequestMapping("/api/vistasReservas")
public class ReservaVistaController {


    @Autowired
    private ReservaVistaService service;

    @GetMapping("/disponibilidad")
    public ResponseEntity<List<VistaDisponibilidadHabitacionDTO>> listarDisponibilidad() {
        return ResponseEntity.ok(service.obtenerDisponibilidadHabitaciones());
    }

    @GetMapping("/historial")
    public ResponseEntity<List<VistaHistorialReservasHuespedDTO>> listarHistorial() {
        return ResponseEntity.ok(service.obtenerHistorialReservas());
    }

    @GetMapping("/habitaciones-disponibles")
    public ResponseEntity<List<VistaHabitacionesDisponiblesDTO>> listarHabitacionesDisponibles() {
        return ResponseEntity.ok(service.obtenerHabitacionesDisponibles());
    }

    @GetMapping("/reservas-activas")
    public ResponseEntity<List<VistaReservasActivasDTO>> listarReservasActivas() {
        return ResponseEntity.ok(service.obtenerReservasActivas());
    }

    @GetMapping("/habitaciones-recepcionista")
    public ResponseEntity<List<VistaHabitacionesDisponiblesRecepcionistaDTO>> listarHabitacionesRecepcionista() {
        return ResponseEntity.ok(service.obtenerHabitacionesRecepcionista());
    }

    @GetMapping("/check-pendiente")
    public ResponseEntity<List<VistaCheckPendienteDTO>> listarCheckPendiente() {
        return ResponseEntity.ok(service.obtenerCheckPendiente());
    }

    @GetMapping("/detalle")
    public ResponseEntity<List<VistaDetalleReservaDTO>> listarDetalleReserva() {
        return ResponseEntity.ok(service.obtenerDetalleReservas());
    }
}
