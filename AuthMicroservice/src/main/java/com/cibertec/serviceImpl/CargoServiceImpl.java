package com.cibertec.serviceImpl;

import com.cibertec.model.Cargo;
import com.cibertec.repository.CargoRepository;
import com.cibertec.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }

    @Override
    public ResponseEntity<List<Cargo>> listarCargos() {
        List<Cargo> listaCargos = cargoRepository.findAll();
        return listaCargos.isEmpty() ? ResponseEntity.noContent().build(): ResponseEntity.ok(listaCargos);
    }

    @Override
    public ResponseEntity<Cargo> agregarCargo(Cargo cargo) {
        if (!esTextoValido(cargo.getDescripcion())) {
            throw new IllegalArgumentException("La descripcion del cargo solo debe contener letras.");
        }
        return ResponseEntity.ok(cargoRepository.save(cargo));
    }

    @Override
    public ResponseEntity<Cargo> actualizarCargo(Cargo cargo, Long id) {
        return cargoRepository.findById(id).map(actual -> {
            if (!esTextoValido(cargo.getDescripcion())) {
                throw new IllegalArgumentException("La descripcion del cargo solo debe contener letras.");
            }
            actual.setDescripcion(cargo.getDescripcion());
            return ResponseEntity.ok(cargoRepository.save(actual));
        }).orElse(ResponseEntity.notFound().build());
    }

}
