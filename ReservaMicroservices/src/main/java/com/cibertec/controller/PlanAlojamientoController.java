package com.cibertec.controller;

import com.cibertec.model.PlanAlojamiento;
import com.cibertec.service.PlanAlojamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanAlojamientoController {
    @Autowired
    private PlanAlojamientoService planAlojamientoService;

    @GetMapping
    public ResponseEntity<List<PlanAlojamiento>> listarPlanes(){
        return planAlojamientoService.listarPlanes();
    }

    @PostMapping
    public ResponseEntity<PlanAlojamiento> guardarPlan(@RequestBody PlanAlojamiento planAlojamiento){
        return planAlojamientoService.guardarPlan(planAlojamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanAlojamiento> actualizarPlan(@RequestBody PlanAlojamiento planAlojamiento, @PathVariable Long id){
        return planAlojamientoService.actualizarPlan(planAlojamiento, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPlan(@PathVariable Long id){
        return planAlojamientoService.eliminarPlan(id);
    }
}
