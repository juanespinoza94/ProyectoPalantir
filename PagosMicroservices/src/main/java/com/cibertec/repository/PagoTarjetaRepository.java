package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.PagoTarjeta;

@Repository
public interface PagoTarjetaRepository extends JpaRepository<PagoTarjeta,Long> {
    void deleteByPagoId(Long idPago);
}
