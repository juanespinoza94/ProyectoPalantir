package com.cibertec.serviceImplement;

import com.cibertec.model.PrecioHabitacionPlan;
import com.cibertec.repository.PrecioHabitacionPlanRepository;
import com.cibertec.service.PrecioHabitacionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrecioHabitacionPlanServiceImpl implements PrecioHabitacionPlanService {

    @Autowired
    private PrecioHabitacionPlanRepository precioHabitacionPlanRepository;

    @Override
    public ResponseEntity<List<PrecioHabitacionPlan>> listarPreciosHabitacion() {

        List<PrecioHabitacionPlan> listaPrecioHabitacionPlan = precioHabitacionPlanRepository.findAll();
        if (listaPrecioHabitacionPlan.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaPrecioHabitacionPlan);
    }

    @Override
    public ResponseEntity<PrecioHabitacionPlan> guardarPrecioHabitacion(PrecioHabitacionPlan precio) {
        return ResponseEntity.ok(precioHabitacionPlanRepository.save(precio));
    }

    @Override
    public ResponseEntity<PrecioHabitacionPlan> actualizarPrecioHabitacion(PrecioHabitacionPlan precio, Long id) {
        return precioHabitacionPlanRepository.findById(id).map(actual -> {
            actual.setPrecio(precio.getPrecio());
            actual.setIdTipoHabitacion (precio.getIdTipoHabitacion());
            actual.setPlanAlojamiento(precio.getPlanAlojamiento());
            return ResponseEntity.ok(precioHabitacionPlanRepository.save(actual));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<PrecioHabitacionPlan>> buscarPorTipoHabitacion(Long idTipoHabitacion) {
        List<PrecioHabitacionPlan> listaPorTipoHabitacion = precioHabitacionPlanRepository.findByIdTipoHabitacion(idTipoHabitacion);
        return ResponseEntity.ok(listaPorTipoHabitacion);
    }
}
