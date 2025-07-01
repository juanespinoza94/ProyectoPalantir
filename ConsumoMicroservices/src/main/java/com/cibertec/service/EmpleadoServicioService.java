package com.cibertec.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cibertec.model.EmpleadoServicio;


public interface EmpleadoServicioService {
	public ResponseEntity <List<EmpleadoServicio>> listarEmpleadoServicio();
	public ResponseEntity <?> agregarEmpleadoServicio(EmpleadoServicio empleadoServicio);
	public ResponseEntity <EmpleadoServicio> editarEmpleadoServicio(EmpleadoServicio empleadoServicio, Long id);
}
