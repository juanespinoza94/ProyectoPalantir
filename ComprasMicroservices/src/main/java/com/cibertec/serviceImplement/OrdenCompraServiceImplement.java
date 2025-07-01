package com.cibertec.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.OrdenCompra;
import com.cibertec.repository.OrdenCompraRepository;
import com.cibertec.service.OrdenCompraService;

@Service
public class OrdenCompraServiceImplement implements OrdenCompraService {

	@Autowired
    private OrdenCompraRepository ordencompraRepository;

    @Override
    public ResponseEntity<List<OrdenCompra>> listarOrdenCompra() {
        List<OrdenCompra> lista = ordencompraRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @Override
    public ResponseEntity<OrdenCompra> agregarOrdenCompra(OrdenCompra ordencompra) {
        OrdenCompra nueva = ordencompraRepository.save(ordencompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @Override
    public ResponseEntity<OrdenCompra> actualizarOrdenCompra(OrdenCompra ordenCompra, Long id) {
        Optional<OrdenCompra> existente = ordencompraRepository.findById(id);
        if (existente.isPresent()) {
            OrdenCompra p = existente.get();
            p.setFechaOrden(ordenCompra.getFechaOrden());
            p.setEstado(ordenCompra.getEstado());
            p.setObservaciones(ordenCompra.getObservaciones());
            p.setProveedor(ordenCompra.getProveedor());

            ordencompraRepository.save(p);
            return ResponseEntity.ok(p);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    public ResponseEntity<?> eliminarOrdenCompra(Long id) {
        Optional<OrdenCompra> ordencompra = ordencompraRepository.findById(id);
        if (ordencompra.isPresent()) {
            ordencompraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
