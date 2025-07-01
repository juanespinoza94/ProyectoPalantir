package com.cibertec.service;

import com.cibertec.model.Cargo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CargoService {

    public ResponseEntity<List<Cargo>> listarCargos();
    public ResponseEntity<Cargo> agregarCargo(Cargo cargo);
    public ResponseEntity<Cargo> actualizarCargo(Cargo cargo, Long id);

}
