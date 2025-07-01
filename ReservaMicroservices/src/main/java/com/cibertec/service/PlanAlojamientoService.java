package com.cibertec.service;

import com.cibertec.model.PlanAlojamiento;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlanAlojamientoService {

    public ResponseEntity<List<PlanAlojamiento>> listarPlanes();
    public ResponseEntity<PlanAlojamiento> guardarPlan(PlanAlojamiento plan);
    public ResponseEntity<PlanAlojamiento> actualizarPlan(PlanAlojamiento plan, Long id);
    public ResponseEntity<?> eliminarPlan(Long id);
}
