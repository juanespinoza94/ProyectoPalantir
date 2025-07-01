package com.cibertec.serviceImpl;

import java.util.List;

import com.cibertec.repository.PagoDetalleRepository;
import com.cibertec.repository.PagoTarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.exception.OperacionNoPermitidaException;
import com.cibertec.model.Pago;
import com.cibertec.repository.PagoRepository;
import com.cibertec.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoRepository pagoRepository;
	@Autowired
	private PagoDetalleRepository pagoDetalleRepository;

	@Autowired
	private PagoTarjetaRepository pagoTarjetaRepository;


	@Override
	public ResponseEntity<List<Pago>> listarPagos(){
		List<Pago> pagos = pagoRepository.findAll();
		
		return pagos.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(pagos);
	}

	private boolean esTextoValido(String texto) {
		return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
	}

	@Override
	public ResponseEntity<Pago> agregarPago(Pago pago) {

		if (!esTextoValido(pago.getMetodoPago())) {
			throw new IllegalArgumentException("El método de pago solo debe contener letras.");
		}
		pago.setEstado("Pagado");
		Pago nuevo = pagoRepository.save(pago);
		return ResponseEntity.ok(nuevo);
	}

	@Override
	public ResponseEntity<Pago> actualizarPago(Pago pago, Long id) {
	    throw new OperacionNoPermitidaException("No está permitido actualizar un pago una vez registrado.");
	}


	@Override
	public ResponseEntity<?> eliminarPago(Long id) {
		return pagoRepository.findById(id).map(pago -> {
			if ("Anulado".equalsIgnoreCase(pago.getEstado())) {
				return ResponseEntity.badRequest().body("El pago ya está anulado.");
			}

			pagoDetalleRepository.deleteByPagoId(id);
			pagoTarjetaRepository.deleteByPagoId(id);

			pago.setEstado("Anulado");
			pagoRepository.save(pago);
			return ResponseEntity.ok().body("Pago anulado correctamente.");
		}).orElse(ResponseEntity.notFound().build());
	}


}
