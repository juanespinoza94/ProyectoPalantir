package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.service.ComprasVistaService;
import com.cibertec.model.VistaOrdenCompraDTO;
import com.cibertec.model.VistaDetalleOrdenCompraDTO;
import com.cibertec.model.VistaProveedoresActivosDTO;
import com.cibertec.model.VistaOrdenesPorProveedorDTO;

@RestController
@RequestMapping("/api/vistasCompras")
public class ComprasVistaController {

	@Autowired
    private ComprasVistaService comprasVistaService;

    @GetMapping("/ordenes-compra")
    public ResponseEntity<List<VistaOrdenCompraDTO>> listarVistaOrdenesCompra() {
        return ResponseEntity.ok(comprasVistaService.listarVistaOrdenesCompra());
    }

    @GetMapping("/detalle-orden")
    public ResponseEntity<List<VistaDetalleOrdenCompraDTO>> listarVistaDetalleOrdenCompra() {
        return ResponseEntity.ok(comprasVistaService.listarVistaDetalleOrdenCompra());
    }

    @GetMapping("/proveedores-activos")
    public ResponseEntity<List<VistaProveedoresActivosDTO>> listarVistaProveedoresActivos() {
        return ResponseEntity.ok(comprasVistaService.listarVistaProveedoresActivos());
    }

    @GetMapping("/ordenes-por-proveedor")
    public ResponseEntity<List<VistaOrdenesPorProveedorDTO>> listarVistaOrdenesPorProveedor() {
        return ResponseEntity.ok(comprasVistaService.listarVistaOrdenesPorProveedor());
    }	
}
