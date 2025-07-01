package com.cibertec.service;

import java.util.List;

import com.cibertec.model.ReservaEmpleadoDTO;
import com.cibertec.model.ReservaUpdateDTO;
import com.cibertec.model.ReservaWebDTO;
import org.springframework.http.ResponseEntity;

import com.cibertec.model.Reserva;

public interface ReservaService {

	
	public ResponseEntity<List<Reserva>> listarReserva();
	public ResponseEntity<Reserva> crearReservaDesdeWeb(ReservaWebDTO dto);
	public ResponseEntity<Reserva> crearReservaDesdeEmpleado(ReservaEmpleadoDTO dto);
	public ResponseEntity<Reserva>  actualizarReserva(ReservaUpdateDTO dto, Long id);
	public ResponseEntity<Reserva> completarReserva(Long id);
	public ResponseEntity<?>  eliminarReserva(Long id);
	
}
