package com.cibertec.service;

import com.cibertec.model.Empleado;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    public ResponseEntity<List<Empleado>> listarEmpleados();
    public ResponseEntity<Empleado> getEmpleadoPorNumeroDocumento(String numeroDocumento);
    public ResponseEntity<List<Empleado>> listarEmpleadosporEstado(String estado);
    public ResponseEntity<List<Empleado>> listarEmpleadosporCargo( Long id);
    public ResponseEntity<Empleado> agregarEmpleado(Empleado empleado);
    public ResponseEntity<Empleado> actualizarEmpleado(Empleado empleado, Long id);
    public ResponseEntity<?> eliminarEmpleado(Long id);
}
