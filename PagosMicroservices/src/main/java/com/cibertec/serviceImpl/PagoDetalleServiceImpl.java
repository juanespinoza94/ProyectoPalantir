package com.cibertec.serviceImpl;

import com.cibertec.model.DetalleReservaDTO;
import com.cibertec.model.Pago;
import com.cibertec.model.PagoDetalle;
import com.cibertec.repository.PagoDetalleRepository;
import com.cibertec.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.cibertec.service.PagoDetalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoDetalleServiceImpl implements PagoDetalleService {

    @Autowired
    private PagoDetalleRepository pagoDetalleRepository;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private DetalleReservaClient detalleReservaClient;

    @Override
    public ResponseEntity<List<PagoDetalle>> listarPagoDetalle() {
        List<PagoDetalle> pagoDetalles = pagoDetalleRepository.findAll();
        return pagoDetalles.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(pagoDetalles);
    }

    @Override
    public ResponseEntity<PagoDetalle> AgregarPagoDetalle(PagoDetalle pagoDetalle) {
        Long idPago = pagoDetalle.getPago().getId();
        Long idDetalle = pagoDetalle.getIdDetalleReserva();

        Pago pago = pagoRepository.findById(idPago)
                .orElseThrow(() -> new IllegalArgumentException("Pago no encontrado"));

        DetalleReservaDTO detalle = detalleReservaClient.obtenerDetallePorId(idDetalle);

        if (!detalle.getReservaId().equals(pago.getIdReserva())) {
            throw new IllegalArgumentException("El detalle no pertenece a la misma reserva del pago");
        }

        PagoDetalle nuevo = pagoDetalleRepository.save(pagoDetalle);
        return ResponseEntity.ok(nuevo);
    }



    @Override
    public ResponseEntity<?> EliminarPagoDetalle(Long id) {
        return pagoDetalleRepository.findById(id).map(detalle -> {
            pagoDetalleRepository.delete(detalle);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
