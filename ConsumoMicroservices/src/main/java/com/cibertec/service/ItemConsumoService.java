package com.cibertec.service;

import java.util.List;

import com.cibertec.model.ProductoDTO;
import com.cibertec.model.ServicioDTO;
import org.springframework.http.ResponseEntity;

import com.cibertec.model.ItemConsumo;

public interface ItemConsumoService {
	
	public ResponseEntity <List<ItemConsumo>> listarItemConsumo();
	public ResponseEntity<ItemConsumo> registrarServicio(ServicioDTO dto);
	public ResponseEntity<ItemConsumo> registrarProducto(ProductoDTO dto);

	public ResponseEntity <ItemConsumo> editarItemConsumo(ItemConsumo itemConsumo, Long id);
	public ResponseEntity <?> eliminarItemConsumo(Long id);
}
