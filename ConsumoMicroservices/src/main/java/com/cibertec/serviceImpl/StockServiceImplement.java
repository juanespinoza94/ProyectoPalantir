package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.Stock;
import com.cibertec.repository.StockRepository;
import com.cibertec.service.StockService;

@Service
public class StockServiceImplement implements StockService{

	@Autowired
	private StockRepository stockRepo;

	@Override
	public ResponseEntity<List<Stock>> listarStock() {
		List<Stock> stock = stockRepo.findAll();

		return stock.isEmpty()
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok(stock);
	}

	@Override
	public ResponseEntity<Stock> agregarStock(Stock stock) {

		if (stock.getCantidadDisponible() < 0) {
			throw new IllegalArgumentException("La cantidad no puede ser negativa.");
		}

		Stock stockNuevo = stockRepo.save(stock);
		return ResponseEntity.ok(stockNuevo);
	}

	@Override
	public ResponseEntity<Stock> editarStock(Stock stock, Long id) {
		if (stock.getCantidadDisponible() < 0) {
			throw new IllegalArgumentException("La cantidad no puede ser negativa.");
		}

		Optional<Stock> stockActualizar = stockRepo.findById(id);

		if (stockActualizar.isPresent()) {
			Stock stockAct = stockActualizar.get();

			stockAct.setCantidadDisponible(stock.getCantidadDisponible());
			stockRepo.save(stockAct);
			return ResponseEntity.status(HttpStatus.OK).body(stockAct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<?> eliminarStock(Long id) {

		Optional<Stock> stock = stockRepo.findById(id);

		if (stock.isPresent()) {
			stockRepo.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Stock con ID " + id + " no encontrado.");
		}
	}

}