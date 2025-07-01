package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.model.ItemConsumo;

@Repository
public interface ItemConsumoRepository extends JpaRepository<ItemConsumo, Long>{

}

