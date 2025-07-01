package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.PagoDetalle;

public interface PagoDetalleService {
	
	public ResponseEntity<List<PagoDetalle>> listarPagoDetalle();
	public ResponseEntity<PagoDetalle> AgregarPagoDetalle(PagoDetalle pagoDetalle);
	public ResponseEntity<?>  EliminarPagoDetalle(Long id);

}
