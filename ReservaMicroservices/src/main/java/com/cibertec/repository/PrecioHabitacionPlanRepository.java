package com.cibertec.repository;

import com.cibertec.model.PrecioHabitacionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecioHabitacionPlanRepository extends JpaRepository<PrecioHabitacionPlan, Long> {
    List<PrecioHabitacionPlan> findByIdTipoHabitacion(Long idTipoHabitacion);
}
