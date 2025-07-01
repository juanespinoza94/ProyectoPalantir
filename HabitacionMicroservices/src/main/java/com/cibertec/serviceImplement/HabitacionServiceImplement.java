package com.cibertec.serviceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cibertec.model.Habitacion;

import com.cibertec.repository.HabitacionRepository;
import com.cibertec.service.HabitacionService;

@Service
public class HabitacionServiceImplement implements HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public ResponseEntity<List<Habitacion>> listarHabitacion() {
        List<Habitacion> lista = habitacionRepository.findAll();
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @Override
    public ResponseEntity<Habitacion> agregarHabitacion(Habitacion habitacion) {
        Habitacion nueva = habitacionRepository.save(habitacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @Override
    public ResponseEntity<List<Habitacion>> listarPorIdTipoYEstado(Long idTipoHabitacion, String estado) {
        List<Habitacion> habitacionesPorIdTipoYEstado = habitacionRepository.findByTipoHabitacionIdAndEstado(idTipoHabitacion, estado);
        if (habitacionesPorIdTipoYEstado.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(habitacionesPorIdTipoYEstado);
    }

    @Override
    public ResponseEntity<Habitacion> actualizarHabitacion(Habitacion habitacion, Long id) {
        Optional<Habitacion> existente = habitacionRepository.findById(id);
        if (existente.isPresent()) {
            Habitacion h = existente.get();
            h.setNumero(habitacion.getNumero());
            h.setEstado(habitacion.getEstado());
            h.setTipoHabitacion(habitacion.getTipoHabitacion());
            habitacionRepository.save(h);
            return ResponseEntity.ok(h);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> eliminarHabitacion(Long id) {
        Optional<Habitacion> habitacion = habitacionRepository.findById(id);
        if (habitacion.isPresent()) {
            habitacionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
}
