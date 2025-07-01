package com.cibertec.controller;

import com.cibertec.model.ProductoVencimientoDTO;
import com.cibertec.model.ProveedorItemDTO;
import com.cibertec.model.StockActualDTO;
import com.cibertec.model.StockProductoDTO;
import com.cibertec.service.InventarioVistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventarioVistas")
public class InventarioVistasController {

    @Autowired
    private InventarioVistasService service;

    @GetMapping("/stockActual")
    public ResponseEntity<List<StockActualDTO>> listarStockActual() {
        return ResponseEntity.ok(service.listarStockActual());
    }

    @GetMapping("/proveedoresItems")
    public ResponseEntity<List<ProveedorItemDTO>> listarProveedoresItems() {
        return ResponseEntity.ok(service.listarProveedoresItems());
    }

    @GetMapping("/stockProductos")
    public ResponseEntity<List<StockProductoDTO>> listarStockProductos() {
        return ResponseEntity.ok(service.listarStockProductos());
    }
    @GetMapping("/productosVencimiento")
    public ResponseEntity<List<ProductoVencimientoDTO>> listarProductosVencimiento() {
        return ResponseEntity.ok(service.listarProductosVencimiento());
    }
}
