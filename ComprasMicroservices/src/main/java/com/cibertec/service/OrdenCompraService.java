package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.OrdenCompra;

public interface OrdenCompraService {

	public ResponseEntity<List<OrdenCompra>> listarOrdenCompra();
	public ResponseEntity<OrdenCompra> agregarOrdenCompra(OrdenCompra ordencompra);
	public ResponseEntity<OrdenCompra>  actualizarOrdenCompra(OrdenCompra ordencompra, Long id);
	public ResponseEntity<?>  eliminarOrdenCompra(Long id);
}
