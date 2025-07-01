package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.BancoDisponible;

public interface BancoDisponibleService {
	
	public ResponseEntity<List<BancoDisponible>> listarBancoDisponible();
	public ResponseEntity<BancoDisponible> AgregarBancoDisponible(BancoDisponible bancoDisponible);
	public ResponseEntity<BancoDisponible>  ActualizarBancoDisponible(BancoDisponible bancoDisponible, Long id);
	public ResponseEntity<?>  EliminarBancoDisponible(Long id);

}
