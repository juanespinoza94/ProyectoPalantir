package com.cibertec.controller;

import com.cibertec.model.PrecioHabitacionPlan;
import com.cibertec.service.PrecioHabitacionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/precioHabitacion")
public class PrecioHabitacionPlanController {

    @Autowired
    private PrecioHabitacionPlanService precioHabitacionPlanService;

    @GetMapping
    public ResponseEntity<List<PrecioHabitacionPlan>> listarPrecioHabitacion(){
        return precioHabitacionPlanService.listarPreciosHabitacion();
    }

    @GetMapping("/tipo/{idTipoHabitacion}")
    public ResponseEntity<List<PrecioHabitacionPlan>> buscarPorTipo(@PathVariable Long idTipoHabitacion) {
        return precioHabitacionPlanService.buscarPorTipoHabitacion(idTipoHabitacion);
    }

    @PostMapping
    public ResponseEntity<PrecioHabitacionPlan> guardarPrecioHabitacion(@RequestBody PrecioHabitacionPlan precioHabitacionPlan){
        return precioHabitacionPlanService.guardarPrecioHabitacion(precioHabitacionPlan);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PrecioHabitacionPlan> actualizarPrecioHabitacion(@RequestBody PrecioHabitacionPlan precioHabitacionPlan, @PathVariable Long id){
        return precioHabitacionPlanService.actualizarPrecioHabitacion(precioHabitacionPlan, id);
    }


}
