package com.cibertec.controller;

import java.util.List;

import com.cibertec.model.*;
import com.cibertec.serviceImplement.EmpleadoClient;
import com.cibertec.serviceImplement.HabitacionClient;
import com.cibertec.serviceImplement.HuespedClient;
import com.cibertec.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.service.ReservaService;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

	@Autowired
	private ReservaService service;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private EmpleadoClient empleadoClient;

	@Autowired
	private HuespedClient huespedClient;

	@Autowired
	private HabitacionClient habitacionClient;

	
	@GetMapping()
	public ResponseEntity<List<Reserva>> listarTipoReserva(){
		return service.listarReserva( );
	}


	@GetMapping("/habitaciones-disponibles")
	public ResponseEntity<List<HabitacionDTO>> listarHabitacionesDisponibles(@RequestParam String tipo){
		List<HabitacionDTO> habitaciones = habitacionClient
				.obtenerDisponiblesPorTipoYEstado(tipo, "Disponible");
		return ResponseEntity.ok(habitaciones);

	}


	@PostMapping("/web")
	public ResponseEntity<Reserva> crearReservaDesdeWeb(
			@RequestBody ReservaWebDTO dto,
			@RequestHeader("Authorization") String token
	) {
		Long idUsuario = jwtUtils.extraerIdDesdeToken(token);
		Long idHuesped = huespedClient.obtenerIdHuespedPorUsuario(idUsuario);
		dto.setHuesped(idHuesped);
		return service.crearReservaDesdeWeb(dto);
	}


	@PostMapping("/empleado")
	public ResponseEntity<Reserva> crearReservaPorEmpleado(
			@RequestBody ReservaEmpleadoDTO dto,
			@RequestHeader("Authorization") String token
	) {
		Long idUsuario = jwtUtils.extraerIdDesdeToken(token);
		Long idEmpleado = empleadoClient.obtenerIdEmpleadoPorUsuario(idUsuario);
		dto.setEmpleado(idEmpleado);
		return service.crearReservaDesdeEmpleado(dto);
	}

	@PutMapping("/{id}")
		public ResponseEntity <Reserva> ActualizarReserva (@RequestBody ReservaUpdateDTO dto , @PathVariable Long id) {
			return service.actualizarReserva(dto, id);
		}

	@PutMapping("/{id}/completar")
	public ResponseEntity<Reserva> completarReserva(@PathVariable Long id) {
		return service.completarReserva(id);
	}

	@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletePago(@PathVariable Long id) {
	        service.eliminarReserva(id);
	        return ResponseEntity.noContent().build();
	}
}
