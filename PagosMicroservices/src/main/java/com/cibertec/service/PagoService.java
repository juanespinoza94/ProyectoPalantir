package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.Pago;

public interface PagoService {
	
	public ResponseEntity<List<Pago>> listarPagos();
	public ResponseEntity<Pago> agregarPago(Pago pago);
	public ResponseEntity<Pago>  actualizarPago(Pago pago, Long id);
	public ResponseEntity<?>  eliminarPago(Long id);
}
