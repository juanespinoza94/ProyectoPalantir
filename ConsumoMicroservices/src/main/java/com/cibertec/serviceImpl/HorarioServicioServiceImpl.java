package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.HorarioServicio;
import com.cibertec.repository.HorarioServicioRepository;
import com.cibertec.service.HorarioServicioService;

@Service
public class HorarioServicioServiceImpl implements HorarioServicioService{

	@Autowired
	private HorarioServicioRepository horarioRepo;
	
	@Override
	public ResponseEntity<List<HorarioServicio>> listarHorarioServicio() {
		List<HorarioServicio> horario = horarioRepo.findAll();
		
		return horario.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(horario);
	}

	@Override
	public ResponseEntity<HorarioServicio> agregarHorarioServicio(HorarioServicio horarioServicio) {
		
		HorarioServicio horarioNuevo = horarioRepo.save(horarioServicio);
		return ResponseEntity.ok(horarioNuevo);
	}

	@Override
	public ResponseEntity<HorarioServicio> editarHorarioServicio(HorarioServicio horarioServicio, Long id) {
		
		Optional<HorarioServicio> horarioServicioActualizar = horarioRepo.findById(id);
		
		if (horarioServicioActualizar.isPresent()) {
			HorarioServicio horarioAct = horarioServicioActualizar.get();
			
			horarioAct.setSolicitudConsumo(horarioServicio.getSolicitudConsumo());
			horarioAct.setFecha(horarioServicio.getFecha());
			horarioAct.setHoraInicio(horarioServicio.getHoraInicio());
			horarioAct.setHoraFin(horarioServicio.getHoraFin());
						
			horarioRepo.save(horarioAct);
			return ResponseEntity.status(HttpStatus.OK).body(horarioAct);	
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
