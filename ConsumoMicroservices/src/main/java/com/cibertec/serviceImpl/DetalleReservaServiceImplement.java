package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.DetalleReserva;
import com.cibertec.repository.DetalleReservaRepository;
import com.cibertec.service.DetalleReservaService;

@Service
public class DetalleReservaServiceImplement implements DetalleReservaService {

	@Autowired
	private DetalleReservaRepository detalleRepo;
	
	@Override
	public ResponseEntity<List<DetalleReserva>> listarDetalleReserva() {
	
		List<DetalleReserva> detalle = detalleRepo.findAll();
		
		return detalle.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(detalle);
	}

	@Override
	public ResponseEntity<DetalleReserva> agregarDetalleReserva(DetalleReserva detalleReserva) {
		// TODO Auto-generated method stub
		DetalleReserva detalleNuevo = detalleRepo.save(detalleReserva);
		return ResponseEntity.ok(detalleNuevo);
	}

	@Override
	public ResponseEntity<DetalleReserva> editarDetalleReserva(DetalleReserva detalleReserva, Long id) {
		Optional<DetalleReserva> detalleReservaActualizar = detalleRepo.findById(id);
		
		if (detalleReservaActualizar.isPresent()) {
			DetalleReserva detalleAct = detalleReservaActualizar.get();
			detalleAct.setIdReserva(detalleReserva.getIdReserva());
			detalleAct.setItemConsumo(detalleReserva.getItemConsumo());
			detalleAct.setCantidad(detalleReserva.getCantidad());
			detalleAct.setMontoUnitario(detalleReserva.getMontoUnitario());
			detalleAct.setMontoTotal(detalleReserva.getMontoTotal());
			
			detalleRepo.save(detalleAct);
			return ResponseEntity.status(HttpStatus.OK).body(detalleAct);	
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}


}
