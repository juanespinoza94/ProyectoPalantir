package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.DetalleReserva;

public interface DetalleReservaService {

	public ResponseEntity <List<DetalleReserva>> listarDetalleReserva();
	public ResponseEntity <DetalleReserva> agregarDetalleReserva(DetalleReserva detalleReserva);
	public ResponseEntity <DetalleReserva> editarDetalleReserva(DetalleReserva detalleReserva, Long id);
}
