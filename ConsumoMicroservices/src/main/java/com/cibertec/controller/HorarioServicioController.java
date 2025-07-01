package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.HorarioServicio;
import com.cibertec.service.HorarioServicioService;

@RestController
@RequestMapping("/api/horarioServicio")
public class HorarioServicioController {

	@Autowired
    private HorarioServicioService horarioServicioService;

	@GetMapping
    public ResponseEntity<List<HorarioServicio>> listarHorarioServicios() {
        return horarioServicioService.listarHorarioServicio();
    }

    @PostMapping
    public ResponseEntity<HorarioServicio> createHorarioServicio(@RequestBody HorarioServicio horarioServicio) {
        return horarioServicioService.agregarHorarioServicio(horarioServicio);
    }

    
    @PutMapping("/{id}") 
	public ResponseEntity <HorarioServicio> actualizarHorarioServicio (@RequestBody HorarioServicio horarioServicio, @PathVariable Long id) {
		return horarioServicioService.editarHorarioServicio(horarioServicio, id);
	}
}
