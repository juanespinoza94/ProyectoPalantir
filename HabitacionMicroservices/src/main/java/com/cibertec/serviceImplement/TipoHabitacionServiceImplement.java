package com.cibertec.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cibertec.model.TipoHabitacion;
import com.cibertec.repository.TipoHabitacionRepository;
import com.cibertec.service.TipoHabitacionService;

@Service
public class TipoHabitacionServiceImplement implements TipoHabitacionService {
	  @Autowired
	    private TipoHabitacionRepository tipoHabitacionRepository;

	    @Override
	    public ResponseEntity<List<TipoHabitacion>> listarTipoHabitacion() {
	        List<TipoHabitacion> lista = tipoHabitacionRepository.findAll();

	        return lista.isEmpty()
	                ? ResponseEntity.noContent().build()
	                : ResponseEntity.ok(lista);
	    }

	    @Override
	    public ResponseEntity<TipoHabitacion> agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
	        TipoHabitacion nuevo = tipoHabitacionRepository.save(tipoHabitacion);
	        return ResponseEntity.ok(nuevo);
	    }

	    @Override
	    public ResponseEntity<TipoHabitacion> actualizarTipoHabitacion(TipoHabitacion tipoHabitacion, Long id) {
	        Optional<TipoHabitacion> tipoActualizar = tipoHabitacionRepository.findById(id);

	        if (tipoActualizar.isPresent()) {
	            TipoHabitacion tipoExistente = tipoActualizar.get();
	            tipoExistente.setPrecio(tipoHabitacion.getPrecio());
	            tipoExistente.setNombre(tipoHabitacion.getNombre());
	            tipoExistente.setDescripcion(tipoHabitacion.getDescripcion());
	            tipoExistente.setNumeroHabitaciones(tipoHabitacion.getNumeroHabitaciones());

	            tipoHabitacionRepository.save(tipoExistente);
	            return ResponseEntity.status(HttpStatus.OK).body(tipoExistente);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	
}
