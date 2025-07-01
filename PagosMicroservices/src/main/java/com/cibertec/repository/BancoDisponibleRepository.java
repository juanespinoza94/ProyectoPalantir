package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cibertec.model.BancoDisponible;

@Repository
public interface BancoDisponibleRepository extends JpaRepository<BancoDisponible, Long>{

    @Query(value = "SELECT * FROM Banco_Disponibles WHERE Estado = 'Activo' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    BancoDisponible obtenerBancoAleatorio();

}
