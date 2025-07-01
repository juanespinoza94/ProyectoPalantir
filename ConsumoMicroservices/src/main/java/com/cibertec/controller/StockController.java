package com.cibertec.controller;

import java.util.List;

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

import com.cibertec.model.Stock;
import com.cibertec.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping
    public ResponseEntity<List<Stock>> listarStock() {
        return stockService.listarStock();
    }

    @PostMapping
    public ResponseEntity<Stock> crearStock(@RequestBody Stock stock) {
        return stockService.agregarStock(stock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Long id) {
        stockService.eliminarStock(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}") 
	public ResponseEntity <Stock> actualizarItemConsumo (@RequestBody Stock stock, @PathVariable Long id) {
		return stockService.editarStock(stock, id);
	}

}
