package com.cibertec.repository;

import com.cibertec.model.Empleado;
import com.cibertec.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findByEstadoIgnoreCase(String estado);
    Optional<Empleado> findByNumeroDocumento(String numeroDocumento);
    List<Empleado> findByCargoId(Long id);
    Optional<Usuario>findByUsuarioId(Long idUsuario);
}
