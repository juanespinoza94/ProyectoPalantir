package com.cibertec.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.Proveedor;
import com.cibertec.repository.ProveedorRepository;
import com.cibertec.service.ProveedorService;


@Service
public class ProveedorServiceImplement implements ProveedorService {

	  @Autowired
	    private ProveedorRepository proveedorRepository;

	    @Override
	    public ResponseEntity<List<Proveedor>> listarProveedor() {
	        List<Proveedor> lista = proveedorRepository.findAll();
	        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
	    }

	    @Override
	    public ResponseEntity<Proveedor> agregarProveedor(Proveedor proveedor) {
	        Proveedor nueva = proveedorRepository.save(proveedor);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
	    }

	    @Override
	    public ResponseEntity<Proveedor> actualizarProveedor(Proveedor proveedor, Long id) {
	        Optional<Proveedor> existente = proveedorRepository.findById(id);
	        if (existente.isPresent()) {
	            Proveedor p = existente.get();
	            p.setContacto(proveedor.getContacto());
	            p.setNombre(proveedor.getNombre());
	            p.setCorreo(proveedor.getCorreo());
	            p.setDireccion(proveedor.getDireccion());
	            p.setTelefono(proveedor.getTelefono());
	            p.setEstado(proveedor.getEstado());

	            proveedorRepository.save(p);
	            return ResponseEntity.ok(p);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @Override
	    public ResponseEntity<?> eliminarProveedor(Long id) {
	        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
	        if (proveedor.isPresent()) {
	            proveedorRepository.deleteById(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

		
}
