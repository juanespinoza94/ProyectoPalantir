package com.cibertec.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cibertec.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.repository.ItemConsumoRepository;
import com.cibertec.service.ItemConsumoService;

@Service
public class ItemConsumoServiceImplement implements ItemConsumoService{

	@Autowired
	private ItemConsumoRepository itemRepo;

	private boolean esTextoValido(String texto) {
		return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ0-9 ,.()¡!¿?\\-]+$");
	}

	@Override
	public ResponseEntity<List<ItemConsumo>> listarItemConsumo() {

		List<ItemConsumo> item = itemRepo.findAll();

		return item.isEmpty()
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok(item);
	}

	@Override
	public ResponseEntity<ItemConsumo> registrarServicio(ServicioDTO dto) {
		ItemConsumo item = new ItemConsumo();
		item.setNombre(dto.getNombre());
		item.setDescripcion(dto.getDescripcion());
		item.setPrecioVenta(dto.getPrecioVenta());
		item.setTipo(ItemConsumo.TipoItem.Servicio);
		item.setTieneStock(false);
		item.setEstado("Disponible");
		item.setStock(null);
		item.setVencimientoProducto(new ArrayList<>());

		ItemConsumo guardado = itemRepo.save(item);
		return ResponseEntity.ok(guardado);
	}

	@Override
	public ResponseEntity<ItemConsumo> registrarProducto(ProductoDTO dto) {
		ItemConsumo item = new ItemConsumo();
		item.setNombre(dto.getNombre());
		if (!esTextoValido(dto.getNombre())) {
			throw new IllegalArgumentException("El nombre no debe contener símbolos especiales.");
		}
		item.setDescripcion(dto.getDescripcion());
		if (!esTextoValido(dto.getDescripcion())) {
			throw new IllegalArgumentException("La descripción no debe contener símbolos especiales.");
		}
		item.setPrecioVenta(dto.getPrecioVenta());
		item.setTipo(ItemConsumo.TipoItem.Producto);
		item.setTieneStock(true);
		item.setEstado("Disponible");

		// Stock
		Stock stock = new Stock();
		stock.setCantidadDisponible(dto.getCantidad());
		stock.setItemConsumo(item);
		item.setStock(stock);

		// Vencimiento
		VencimientoProducto venc = new VencimientoProducto();
		venc.setFechaVencimiento(dto.getFechaVencimiento());
		venc.setItemConsumo(item);
		item.setVencimientoProducto(List.of(venc));

		ItemConsumo guardado = itemRepo.save(item);
		return ResponseEntity.ok(guardado);
	}


	@Override
	public ResponseEntity<ItemConsumo> editarItemConsumo(ItemConsumo itemConsumo, Long id) {

		Optional<ItemConsumo> itemConsumoActualizar = itemRepo.findById(id);

		if (itemConsumoActualizar.isPresent()) {
			ItemConsumo itemAct = itemConsumoActualizar.get();
			itemAct.setNombre(itemConsumo.getNombre());
			itemAct.setDescripcion(itemConsumo.getDescripcion());
			if (itemConsumo.getTipo() != null) {
				itemAct.setTipo(itemConsumo.getTipo());
			}
			itemAct.setPrecioVenta(itemConsumo.getPrecioVenta());
			itemAct.setTieneStock(itemConsumo.getTieneStock());
			itemAct.setEstado(itemConsumo.getEstado());

			itemRepo.save(itemAct);
			return ResponseEntity.status(HttpStatus.OK).body(itemAct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<?> eliminarItemConsumo(Long id) {

		return itemRepo.findById(id).map(itemConsumo -> {
			itemConsumo.setEstado("No Disponible");
			itemRepo.save(itemConsumo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}