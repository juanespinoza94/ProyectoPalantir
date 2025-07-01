package com.cibertec.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.ItemProveedor;
import com.cibertec.repository.ItemProveedorRepository;
import com.cibertec.service.ItemProveedorService;

@Service
public class ItemProveedorServiceImplement implements ItemProveedorService{

	@Autowired
    private ItemProveedorRepository itemproveedorRepository;

    @Override
    public ResponseEntity<List<ItemProveedor>> listarItemProveedor() {
        List<ItemProveedor> lista = itemproveedorRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }
}