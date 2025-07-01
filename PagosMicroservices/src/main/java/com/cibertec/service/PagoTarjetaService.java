package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.PagoTarjeta;

public interface PagoTarjetaService {
	
	public ResponseEntity<List<PagoTarjeta>> listarPagoTarjeta();
	public ResponseEntity<PagoTarjeta> AgregarPagoTarjeta(PagoTarjeta pagoTarjeta);
	public ResponseEntity<?>  EliminarPagoTarjeta(Long id);

}
