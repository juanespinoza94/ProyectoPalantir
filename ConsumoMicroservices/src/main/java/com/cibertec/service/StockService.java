package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.Stock;

public interface StockService {
	public ResponseEntity <List<Stock>> listarStock();
	public ResponseEntity <Stock> agregarStock(Stock stock);
	public ResponseEntity <Stock> editarStock(Stock stock, Long id);
	public ResponseEntity <?> eliminarStock(Long id);
}
