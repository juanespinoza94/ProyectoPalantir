package com.cibertec.serviceImplement;

import com.cibertec.model.PlanAlojamiento;
import com.cibertec.model.Reserva;
import com.cibertec.repository.PlanAlojamientoRepository;
import com.cibertec.service.PlanAlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanAlojamientoServiceImpl implements PlanAlojamientoService {

    @Autowired
    private PlanAlojamientoRepository planAlojamientoRepository;

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }


    @Override
    public ResponseEntity<List<PlanAlojamiento>> listarPlanes() {
        List<PlanAlojamiento> planes = planAlojamientoRepository.findAll();
        if(planes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(planes);
    }

    @Override
    public ResponseEntity<PlanAlojamiento> guardarPlan(PlanAlojamiento plan) {
        if (!esTextoValido(plan.getNombre())) {
            throw new IllegalArgumentException("El nombre del plan solo debe contener letras.");
        }
        return ResponseEntity.ok(planAlojamientoRepository.save(plan));
    }

    @Override
    public ResponseEntity<PlanAlojamiento> actualizarPlan(PlanAlojamiento plan, Long id) {
        return planAlojamientoRepository.findById(id).map(actual -> {
            if (!esTextoValido(plan.getNombre())) {
                throw new IllegalArgumentException("El nombre del banco solo debe contener letras.");
            }
            actual.setNombre(plan.getNombre());
            actual.setDuracionDias(plan.getDuracionDias());
            actual.setIncluyeDesayuno(plan.getIncluyeDesayuno());
            actual.setIncluyeBebidas(plan.getIncluyeBebidas());
            return ResponseEntity.ok(planAlojamientoRepository.save(actual));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> eliminarPlan(Long id) {
        Optional<PlanAlojamiento> planOpt = planAlojamientoRepository.findById(id);
        if (planOpt.isPresent()) {
            PlanAlojamiento plan = planOpt.get();
            plan.setEstado("Inactivo");
            planAlojamientoRepository.save(plan);
            return ResponseEntity.ok("Plan cancelado exitosamente.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
