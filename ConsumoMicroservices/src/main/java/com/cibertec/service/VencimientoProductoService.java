package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.VencimientoProducto;

public interface VencimientoProductoService {

	public ResponseEntity <List<VencimientoProducto>> listarVencimientoProducto();
	public ResponseEntity <VencimientoProducto> agregarVencimientoProducto(VencimientoProducto vencimientoProducto);
	public ResponseEntity <VencimientoProducto> editarVencimientoProducto(VencimientoProducto vencimientoProducto, Long id);
	public ResponseEntity <?> eliminarVencimientoProducto(Long id);
}
