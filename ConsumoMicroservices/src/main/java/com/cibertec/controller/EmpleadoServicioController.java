package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.EmpleadoServicio;
import com.cibertec.service.EmpleadoServicioService;

@RestController
@RequestMapping("/api/empleadoServicio")
public class EmpleadoServicioController {
   
	@Autowired
    private EmpleadoServicioService empleadoServicioService;

    @GetMapping
    public ResponseEntity<List<EmpleadoServicio>> listar() {
        return empleadoServicioService.listarEmpleadoServicio();
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody EmpleadoServicio empleadoServicio) {
        return empleadoServicioService.agregarEmpleadoServicio(empleadoServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoServicio> actualizar(@RequestBody EmpleadoServicio empleadoServicio, @PathVariable Long id) {
        return empleadoServicioService.editarEmpleadoServicio(empleadoServicio, id);
    }


}
