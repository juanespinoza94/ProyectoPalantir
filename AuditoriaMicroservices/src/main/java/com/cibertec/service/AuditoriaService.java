package com.cibertec.service;

import com.cibertec.model.Auditoria;

import java.time.LocalDateTime;
import java.util.List;

public interface AuditoriaService {

    List<Auditoria> listar();

    Auditoria guardar(Auditoria auditoria);

    List<Auditoria> buscarPorEmpleado(Long idEmpleado);

    List<Auditoria> buscarPorTabla(String tabla);

    List<Auditoria> buscarPorAccion(String accion);

    List<Auditoria> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);
}
