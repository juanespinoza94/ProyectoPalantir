package com.cibertec.serviceImplement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.cibertec.model.ReservaEmpleadoDTO;
import com.cibertec.model.ReservaUpdateDTO;
import com.cibertec.model.ReservaWebDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.Reserva;
import com.cibertec.repository.ReservaRepository;
import com.cibertec.service.ReservaService;

@Service
public class ReservaServiceImplement implements ReservaService {

	
	 @Autowired
	    private ReservaRepository ReservaRepository;
	@Autowired
	private EmpleadoClient empleadoClient;

	@Override
	public ResponseEntity<List<Reserva>> listarReserva() {
		List<Reserva> lista = ReservaRepository.findAll();
		return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	}

	@Override
	public ResponseEntity<Reserva> crearReservaDesdeWeb(ReservaWebDTO dto) {

		if (dto.getCantidadHuespedes() < 1 || dto.getCantidadHuespedes() > 4) {
			throw new IllegalArgumentException("La cantidad de huéspedes debe estar entre 1 y 4.");
		}

		if (dto.getFechaInicio().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a hoy.");
		}

		Reserva reserva = new Reserva();
		reserva.setCantidadHuespedes(dto.getCantidadHuespedes());
		reserva.setFechaInicio(dto.getFechaInicio());
		reserva.setFechaFin(dto.getFechaFin());
		reserva.setHabitacion(dto.getHabitacion());
		reserva.setHuesped(dto.getHuesped());
		reserva.setOrigenReserva(Reserva.OrigenReserva.Web);
		reserva.setEstado("Pendiente");
		reserva.setEmpleado(null);

		return ResponseEntity.ok(ReservaRepository.save(reserva));
	}
	@Override
	public ResponseEntity<Reserva> crearReservaDesdeEmpleado(ReservaEmpleadoDTO dto) {

		if (dto.getCantidadHuespedes() < 1 || dto.getCantidadHuespedes() > 4) {
			throw new IllegalArgumentException("La cantidad de huéspedes debe estar entre 1 y 4.");
		}

		if (dto.getFechaInicio().isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a hoy.");
		}

		Reserva reserva = new Reserva();
		reserva.setCantidadHuespedes(dto.getCantidadHuespedes());
		reserva.setFechaInicio(dto.getFechaInicio());
		reserva.setFechaFin(dto.getFechaFin());
		reserva.setHabitacion(dto.getHabitacion());
		reserva.setHuesped(dto.getHuesped());
		reserva.setEmpleado(dto.getEmpleado());
		reserva.setOrigenReserva(Reserva.OrigenReserva.Empleado);
		reserva.setEstado("Pendiente");

		Reserva guardada = ReservaRepository.save(reserva);
		return ResponseEntity.ok(guardada);
	}


	@Override
	public ResponseEntity<Reserva> actualizarReserva(ReservaUpdateDTO dto, Long id) {
		Optional<Reserva> existente = ReservaRepository.findById(id);

		if (dto.getCantidadHuespedes() < 1 || dto.getCantidadHuespedes() > 4) {
			throw new IllegalArgumentException("La cantidad de huéspedes debe estar entre 1 y 4.");
		}

		if (existente.isPresent()) {
			if (dto.getFechaInicio().isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("La fecha de inicio no puede ser anterior a hoy.");
			}

			Reserva r = existente.get();

			r.setCantidadHuespedes(dto.getCantidadHuespedes());
			r.setFechaInicio(dto.getFechaInicio());
			r.setFechaFin(dto.getFechaFin());
			r.setEstado(dto.getEstado());
			r.setHabitacion(dto.getHabitacion());


			ReservaRepository.save(r);
			return ResponseEntity.ok(r);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Reserva> completarReserva(Long id) {
		Optional<Reserva> reservaOpt = ReservaRepository.findById(id);

		if (reservaOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Reserva reserva = reservaOpt.get();

		if (!"Pendiente".equalsIgnoreCase(reserva.getEstado())) {
			return ResponseEntity
					.badRequest()
					.body(null); // O puedes lanzar una excepción con mensaje personalizado
		}

		reserva.setEstado("Completada");
		ReservaRepository.save(reserva);

		return ResponseEntity.ok(reserva);
	}

	@Override
	public ResponseEntity<?> eliminarReserva(Long id) {
		Optional<Reserva> reservaOpt = ReservaRepository.findById(id);
		if (reservaOpt.isPresent()) {
			Reserva reserva = reservaOpt.get();
			reserva.setEstado("Cancelada");
			ReservaRepository.save(reserva);
			return ResponseEntity.ok("Reserva cancelada exitosamente.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
