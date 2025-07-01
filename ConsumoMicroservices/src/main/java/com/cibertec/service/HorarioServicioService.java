package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.HorarioServicio;

public interface HorarioServicioService {

	public ResponseEntity <List<HorarioServicio>> listarHorarioServicio();
	public ResponseEntity <HorarioServicio> agregarHorarioServicio(HorarioServicio horarioServicio);
	public ResponseEntity <HorarioServicio> editarHorarioServicio(HorarioServicio horarioServicio, Long id);
}
