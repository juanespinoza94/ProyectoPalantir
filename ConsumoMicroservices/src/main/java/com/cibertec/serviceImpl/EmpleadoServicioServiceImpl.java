package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.EmpleadoServicio;
import com.cibertec.model.SolicitudConsumo;
import com.cibertec.repository.EmpleadoServicioRepository;
import com.cibertec.repository.SolicitudConsumoRepository;
import com.cibertec.service.EmpleadoServicioService;

@Service
public class EmpleadoServicioServiceImpl implements EmpleadoServicioService{


	@Autowired
	private SolicitudConsumoRepository solicitudConsumoRepository;

	@Autowired
	private EmpleadoServicioRepository empleadoRepo;

	@Override
	public ResponseEntity<List<EmpleadoServicio>> listarEmpleadoServicio() {
		List<EmpleadoServicio> empleado = empleadoRepo.findAll();

		return empleado.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(empleado);
	}

	@Override
	public ResponseEntity<?> agregarEmpleadoServicio(EmpleadoServicio empleadoServicio) {
		if (empleadoServicio.getSolicitudConsumo() == null ||
		        empleadoServicio.getSolicitudConsumo().getId() == null) {
		        return ResponseEntity.badRequest().body("Solicitud de consumo no puede ser nula."); // o lanza una excepción personalizada
		    }

		// Recuperar la entidad real desde la base de datos
	    Long idSolicitud = empleadoServicio.getSolicitudConsumo().getId();

		// ✅ Validación para evitar duplicado
		if (empleadoRepo.findBySolicitudConsumoId(idSolicitud).isPresent()) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Ya existe un empleado asignado a esta solicitud de consumo.");
		}

	    SolicitudConsumo solicitud = solicitudConsumoRepository.findById(idSolicitud)
	        .orElseThrow(() -> new RuntimeException("Solicitud de consumo no encontrada con ID: " + idSolicitud));

	    empleadoServicio.setSolicitudConsumo(solicitud);

		EmpleadoServicio empleadoNuevo = empleadoRepo.save(empleadoServicio);
		return ResponseEntity.ok(empleadoNuevo);
	}

	@Override
	public ResponseEntity<EmpleadoServicio> editarEmpleadoServicio(EmpleadoServicio empleadoServicio, Long id) {
		Optional<EmpleadoServicio> empleadoServicioActualizar = empleadoRepo.findById(id);

		if (empleadoServicioActualizar.isPresent()) {
			EmpleadoServicio empleadoAct = empleadoServicioActualizar.get();

			empleadoAct.setSolicitudConsumo(empleadoServicio.getSolicitudConsumo());
			empleadoAct.setIdEmpleado(empleadoServicio.getIdEmpleado());


			empleadoRepo.save(empleadoAct);
			return ResponseEntity.status(HttpStatus.OK).body(empleadoAct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
