package com.cibertec.controller;

import com.cibertec.model.VistaPagosReserva;
import com.cibertec.model.VistaReservasPendientes;
import com.cibertec.service.PagosVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/pagosVistas")
public class PagosVistaController {

    @Autowired
    private PagosVistaService pagosVistaService;

    @GetMapping("/pagosReserva")
    public ResponseEntity<List<VistaPagosReserva>> getPagosReserva() {
        return ResponseEntity.ok(pagosVistaService.listarPagosReserva());
    }

    @GetMapping("/reservasPendientes")
    public ResponseEntity<List<VistaReservasPendientes>> getReservasPendientes() {
        return ResponseEntity.ok(pagosVistaService.listarReservasPendientes());
    }

}
