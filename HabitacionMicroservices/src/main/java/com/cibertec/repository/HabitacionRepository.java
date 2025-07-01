package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Habitacion;

import java.util.List;
import java.util.Optional;


@Repository
public interface HabitacionRepository  extends JpaRepository<Habitacion, Long>{

    List<Habitacion> findByTipoHabitacionIdAndEstado(Long idTipoHabitacion, String estado);

}
