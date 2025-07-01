package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.Proveedor;

public interface ProveedorService {

	
	public ResponseEntity<List<Proveedor>> listarProveedor();
	public ResponseEntity<Proveedor> agregarProveedor(Proveedor proveedor);
	public ResponseEntity<Proveedor>  actualizarProveedor(Proveedor proveedor, Long id);
	public ResponseEntity<?>  eliminarProveedor(Long id);
}
