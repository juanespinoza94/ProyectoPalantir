package com.cibertec.serviceImpl;

import com.cibertec.model.Auditoria;
import com.cibertec.repository.AuditoriaRepository;
import com.cibertec.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public List<Auditoria> listar() {
        return auditoriaRepository.findAll();
    }

    @Override
    public Auditoria guardar(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    @Override
    public List<Auditoria> buscarPorEmpleado(Long idEmpleado) {
        return auditoriaRepository.findByIdEmpleado(idEmpleado);
    }

    @Override
    public List<Auditoria> buscarPorTabla(String tabla) {
        return auditoriaRepository.findByTablaAfectada(tabla);
    }

    @Override
    public List<Auditoria> buscarPorAccion(String accion) {
        return auditoriaRepository.findByAccion(accion);
    }

    @Override
    public List<Auditoria> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return auditoriaRepository.findByFechaBetween(inicio, fin);
    }
}

