package com.cibertec.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.VencimientoProducto;
import com.cibertec.repository.VencimientoProductoRepository;
import com.cibertec.service.VencimientoProductoService;

@Service
public class VencimientoProductoServiceImplement implements VencimientoProductoService{

	@Autowired
	private VencimientoProductoRepository vencimientoRepo;
	
	@Override
	public ResponseEntity<List<VencimientoProducto>> listarVencimientoProducto() {
		List<VencimientoProducto> vencimiento = vencimientoRepo.findAll();
		
		return vencimiento.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(vencimiento);
	}



	@Override
	public ResponseEntity<VencimientoProducto> agregarVencimientoProducto(VencimientoProducto vencimientoProducto) {
		
		VencimientoProducto vencimientoNuevo = vencimientoRepo.save(vencimientoProducto);
		return ResponseEntity.ok(vencimientoNuevo);
	}



	@Override
	public ResponseEntity<VencimientoProducto> editarVencimientoProducto(VencimientoProducto vencimientoProducto,
			Long id) {
		Optional<VencimientoProducto> vencimientoActualizar = vencimientoRepo.findById(id);
		
		if (vencimientoActualizar.isPresent()) {
			VencimientoProducto vencimientoAct = vencimientoActualizar.get();
			
			vencimientoAct.setFechaVencimiento(vencimientoProducto.getFechaVencimiento());
			vencimientoAct.setAlerta(vencimientoProducto.getAlerta());
			
			vencimientoRepo.save(vencimientoAct);
			return ResponseEntity.status(HttpStatus.OK).body(vencimientoAct);	
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
	

	@Override
	public ResponseEntity<?> eliminarVencimientoProducto(Long id) {

		Optional<VencimientoProducto> vencimiento = vencimientoRepo.findById(id);
		
	    if (vencimiento.isPresent()) {
	        vencimientoRepo.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Vencimiento Producto con ID " + id + " no encontrado.");
	    }
	}




}
