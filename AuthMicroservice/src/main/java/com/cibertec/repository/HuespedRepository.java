package com.cibertec.repository;

import com.cibertec.model.Empleado;
import com.cibertec.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {

    List<Huesped> findByEstadoIgnoreCase(String estado);
    Optional<Huesped> findByNumeroDocumento(String numeroDocumento);
    Optional<Huesped> findByUsuarioId(Long usuarioId);
}
