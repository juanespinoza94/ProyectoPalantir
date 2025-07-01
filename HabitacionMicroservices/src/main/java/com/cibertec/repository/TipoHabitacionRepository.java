package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.TipoHabitacion;

@Repository
public interface TipoHabitacionRepository  extends JpaRepository<TipoHabitacion, Long>{

}
