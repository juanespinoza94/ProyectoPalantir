package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.SolicitudConsumo;

public interface SolicitudConsumoService {
	public ResponseEntity <List<SolicitudConsumo>> listarSolicitudConsumo();
	public ResponseEntity <SolicitudConsumo> agregarSolicitudConsumo(SolicitudConsumo solicitudConsumo);
	public ResponseEntity <SolicitudConsumo> editarSolicitudConsumo(SolicitudConsumo solicitudConsumo, Long id);
	public ResponseEntity <?> eliminarSolicitudConsumo(Long id);
}
