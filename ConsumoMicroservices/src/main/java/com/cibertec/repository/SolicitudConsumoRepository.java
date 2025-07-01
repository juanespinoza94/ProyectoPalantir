package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.SolicitudConsumo;

@Repository
public interface SolicitudConsumoRepository extends JpaRepository<SolicitudConsumo, Long>{

}
