package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	
	
}
