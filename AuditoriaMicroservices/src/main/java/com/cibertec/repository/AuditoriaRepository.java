package com.cibertec.repository;

import com.cibertec.model.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

    List<Auditoria> findByIdEmpleado(Long idEmpleado);

    List<Auditoria> findByTablaAfectada(String tabla);

    List<Auditoria> findByAccion(String accion);

    List<Auditoria> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}
