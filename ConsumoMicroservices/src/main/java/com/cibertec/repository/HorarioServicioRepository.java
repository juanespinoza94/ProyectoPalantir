package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.HorarioServicio;

@Repository
public interface HorarioServicioRepository extends JpaRepository<HorarioServicio, Long>{

}
