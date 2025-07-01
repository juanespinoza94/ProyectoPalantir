package com.cibertec.controller;

import java.util.ArrayList;
import java.util.List;

import com.cibertec.model.*;
import com.cibertec.repository.ItemConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.service.ItemConsumoService;
@RestController
@RequestMapping("/api/itemConsumo")
public class ItemConsumoController {

    @Autowired
    private ItemConsumoService itemConsumoService;

    @GetMapping
    public ResponseEntity<List<ItemConsumo>> listarItemConsumos() {
        return itemConsumoService.listarItemConsumo();
    }

    @PostMapping("/servicio")
    public ResponseEntity<ItemConsumo> registrarServicio(@RequestBody ServicioDTO dto) {
        return itemConsumoService.registrarServicio(dto);
    }

    @PostMapping("/producto")
    public ResponseEntity<ItemConsumo> registrarProducto(@RequestBody ProductoDTO dto) {
        return itemConsumoService.registrarProducto(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemConsumo> actualizarItemConsumo(@RequestBody ItemConsumo itemConsumo, @PathVariable Long id) {
        return itemConsumoService.editarItemConsumo(itemConsumo, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarItemConsumo(@PathVariable Long id) {
        return itemConsumoService.eliminarItemConsumo(id);
    }
}
