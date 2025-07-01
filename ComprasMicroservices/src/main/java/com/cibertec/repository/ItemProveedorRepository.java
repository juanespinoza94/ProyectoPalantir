package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.ItemProveedor;
import com.cibertec.model.ItemProveedorId;

@Repository
public interface ItemProveedorRepository extends JpaRepository<ItemProveedor, ItemProveedorId > {

	
}
