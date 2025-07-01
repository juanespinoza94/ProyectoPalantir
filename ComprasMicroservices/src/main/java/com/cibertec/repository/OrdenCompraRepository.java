package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.OrdenCompra;

@Repository
public interface OrdenCompraRepository  extends JpaRepository<OrdenCompra, Long>{

}
