package com.cibertec.controller;

import com.cibertec.model.Empleado;
import com.cibertec.repository.EmpleadoRepository;
import com.cibertec.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/documento/{numeroDocumento}")
    public ResponseEntity<Empleado> getEmpleadoPorDocumento(@PathVariable String numeroDocumento) {
        return empleadoService.getEmpleadoPorNumeroDocumento(numeroDocumento);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Empleado>> listarPorEstado(@PathVariable String estado) {
        return empleadoService.listarEmpleadosporEstado(estado);
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<List<Empleado>> listarPorCargo(@PathVariable Long id) {
        return empleadoService.listarEmpleadosporCargo(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Long> obtenerIdEmpleadoPorUsuario(@PathVariable Long idUsuario) {
        return empleadoRepository.findByUsuarioId(idUsuario)
                .map(empleado -> ResponseEntity.ok(empleado.getId()))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.agregarEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizarEmpleado(empleado, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id) {
        return empleadoService.eliminarEmpleado(id);
    }
}
