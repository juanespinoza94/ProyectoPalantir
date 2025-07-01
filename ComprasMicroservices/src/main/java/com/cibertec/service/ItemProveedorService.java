package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.ItemProveedor;

public interface ItemProveedorService {

	public ResponseEntity<List<ItemProveedor>> listarItemProveedor();

}
