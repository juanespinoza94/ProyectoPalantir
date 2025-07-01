package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.DetalleOrden;

public interface DetalleOrdenService {

	public ResponseEntity<List<DetalleOrden>> listarDetalleOrden();
	public ResponseEntity<DetalleOrden> agregarDetalleOrden(DetalleOrden detalleorden);
	public ResponseEntity<DetalleOrden>  actualizarDetalleOrden(DetalleOrden detalleorden, Long id);
	public ResponseEntity<?>  eliminarDetalleOrden(Long id);
}
