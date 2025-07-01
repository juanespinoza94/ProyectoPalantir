package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.cibertec.model.ItemConsumo;
import com.cibertec.repository.ItemConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.SolicitudConsumo;

import com.cibertec.repository.SolicitudConsumoRepository;
import com.cibertec.service.SolicitudConsumoService;

@Service
public class SolicitudConsumoServiceImplement implements SolicitudConsumoService{

	@Autowired
	private ItemConsumoRepository itemConsumoRepo;

	@Autowired
	private SolicitudConsumoRepository solicitudRepo;

	@Override
	public ResponseEntity<List<SolicitudConsumo>> listarSolicitudConsumo() {
		List<SolicitudConsumo> solicitud = solicitudRepo.findAll();

		return solicitud.isEmpty()
				? ResponseEntity.noContent().build()
				: ResponseEntity.ok(solicitud);
	}

	@Override
	public ResponseEntity<SolicitudConsumo> agregarSolicitudConsumo(SolicitudConsumo solicitudConsumo) {

		if (solicitudConsumo.getCantidad() == null || solicitudConsumo.getCantidad() <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor o igual a 1.");
		}

		Long idItem = solicitudConsumo.getItemConsumo().getId();

		// Validar si el item existe
		ItemConsumo item = itemConsumoRepo.findById(idItem)
				.orElseThrow(() -> new IllegalArgumentException("ItemConsumo no encontrado con ID: " + idItem));

		solicitudConsumo.setItemConsumo(item); // Asigna
		SolicitudConsumo solicitudNuevo = solicitudRepo.save(solicitudConsumo);
		return ResponseEntity.ok(solicitudNuevo);
	}

	@Override
	public ResponseEntity<SolicitudConsumo> editarSolicitudConsumo(SolicitudConsumo solicitudConsumo, Long id) {

		if (solicitudConsumo.getCantidad() == null || solicitudConsumo.getCantidad() <= 0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor o igual a 1.");
		}

		Optional<SolicitudConsumo> solicitudConsumooActualizar = solicitudRepo.findById(id);

		if (solicitudConsumooActualizar.isPresent()) {
			SolicitudConsumo soliAct = solicitudConsumooActualizar.get();
			soliAct.setIdReserva(solicitudConsumo.getIdReserva());

			Long idItem = solicitudConsumo.getItemConsumo().getId();
			ItemConsumo item = itemConsumoRepo.findById(idItem)
					.orElseThrow(() -> new IllegalArgumentException("ItemConsumo no encontrado con ID: " + idItem));
			soliAct.setItemConsumo(item);

			soliAct.setCantidad(solicitudConsumo.getCantidad());
			soliAct.setEstado(solicitudConsumo.getEstado());
			soliAct.setFechaSolicitud(solicitudConsumo.getFechaSolicitud());
			soliAct.setFechaAtencion(solicitudConsumo.getFechaAtencion());

			solicitudRepo.save(soliAct);
			return ResponseEntity.status(HttpStatus.OK).body(soliAct);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<?> eliminarSolicitudConsumo(Long id) {
		return solicitudRepo.findById(id).map(solicitudConsumo -> {
			solicitudConsumo.setEstado("No Disponible");
			solicitudRepo.save(solicitudConsumo);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}