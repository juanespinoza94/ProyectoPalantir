package com.cibertec.service;


import com.cibertec.model.PrecioHabitacionPlan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrecioHabitacionPlanService {
    public ResponseEntity<List<PrecioHabitacionPlan>> listarPreciosHabitacion();
    public ResponseEntity<PrecioHabitacionPlan> guardarPrecioHabitacion(PrecioHabitacionPlan precio);
    public ResponseEntity<PrecioHabitacionPlan> actualizarPrecioHabitacion(PrecioHabitacionPlan precio, Long id);
    public ResponseEntity<List<PrecioHabitacionPlan>> buscarPorTipoHabitacion(Long idTipoHabitacion);
}
