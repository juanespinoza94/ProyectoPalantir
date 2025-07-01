package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.PagoDetalle;

@Repository
public interface PagoDetalleRepository extends JpaRepository<PagoDetalle, Long> {
    void deleteByPagoId(Long idPago);
}
