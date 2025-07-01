package com.cibertec.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.DetalleOrden;
import com.cibertec.repository.DetalleOrdenRepository;
import com.cibertec.service.DetalleOrdenService;

@Service
public class DetalleOrdenServiceImplement implements DetalleOrdenService{

	@Autowired
    private DetalleOrdenRepository detalleordenRepository;

    @Override
    public ResponseEntity<List<DetalleOrden>> listarDetalleOrden() {
        List<DetalleOrden> lista = detalleordenRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @Override
    public ResponseEntity<DetalleOrden> agregarDetalleOrden(DetalleOrden detalleorden) {
        DetalleOrden nueva = detalleordenRepository.save(detalleorden);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @Override
    public ResponseEntity<DetalleOrden> actualizarDetalleOrden(DetalleOrden detalleOrden, Long id) {
        Optional<DetalleOrden> existente = detalleordenRepository.findById(id);
        if (existente.isPresent()) {
            DetalleOrden p = existente.get();
            p.setOrdencompra(detalleOrden.getOrdencompra());
            p.setItemConsumo(detalleOrden.getItemConsumo());
            p.setCantidad(detalleOrden.getCantidad());
            p.setPrecioCompra(detalleOrden.getPrecioCompra());

            detalleordenRepository.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<?> eliminarDetalleOrden(Long id) {
        Optional<DetalleOrden> detalleorden = detalleordenRepository.findById(id);
        if (detalleorden.isPresent()) {
            detalleordenRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
