package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.ItemProveedor;
import com.cibertec.service.ItemProveedorService;

@RestController
@RequestMapping("/api/itemProveedor")
public class ItemProveedorController {

	@Autowired
	private ItemProveedorService service;
	
	@GetMapping()
	public ResponseEntity<List<ItemProveedor>> listarTipoItemProveedor(){
		return service.listarItemProveedor( );
	}
}
