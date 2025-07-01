package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.EmpleadoServicio;

import java.util.Optional;

@Repository
public interface EmpleadoServicioRepository extends JpaRepository<EmpleadoServicio, Long>{
    Optional<EmpleadoServicio> findBySolicitudConsumoId(Long idSolicitudConsumo);

}
