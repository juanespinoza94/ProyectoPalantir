package com.cibertec.repository;

import com.cibertec.model.DummyEntity;
import com.cibertec.model.VistaPagosReserva;
import com.cibertec.model.VistaReservasPendientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagosVistaRepository extends JpaRepository<DummyEntity, Long> {

    @Query(value = "SELECT * FROM vista_pagos_reserva", nativeQuery = true)
    List<VistaPagosReserva> obtenerPagosReserva();

    @Query(value = "SELECT * FROM vista_reservas_pendientes", nativeQuery = true)
    List<VistaReservasPendientes> obtenerReservasPendientes();
}
