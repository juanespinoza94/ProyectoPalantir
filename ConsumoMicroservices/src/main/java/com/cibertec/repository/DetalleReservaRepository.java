package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.DetalleReserva;

import java.util.Optional;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Long>{

}
