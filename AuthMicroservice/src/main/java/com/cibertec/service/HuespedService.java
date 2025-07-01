package com.cibertec.service;

import com.cibertec.model.Empleado;
import com.cibertec.model.Huesped;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HuespedService {
    public ResponseEntity<List<Huesped>> listarHuespedes();
    public ResponseEntity<Huesped> getHuespedPorNumeroDocumento(String numeroDocumento);
    public ResponseEntity<List<Huesped>> listarHuespedesporEstado(String estado);
    public ResponseEntity<Huesped> agregarHuesped(Huesped huesped);
    public ResponseEntity<Huesped> actualizarHuesped(Huesped huesped, Long id);
    public ResponseEntity<?> eliminarHuesped(Long id);
}
