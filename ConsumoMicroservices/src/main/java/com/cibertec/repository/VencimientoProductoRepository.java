package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.VencimientoProducto;

@Repository
public interface VencimientoProductoRepository extends JpaRepository<VencimientoProducto, Long>{

}
