package com.cibertec.repository;

import com.cibertec.model.PlanAlojamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanAlojamientoRepository extends JpaRepository<PlanAlojamiento, Long> {
}
