package com.cibertec.serviceImpl;

import com.cibertec.model.BancoDisponible;
import com.cibertec.repository.BancoDisponibleRepository;
import com.cibertec.service.BancoDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoDisponibleServiceImpl implements BancoDisponibleService {

    @Autowired
    private BancoDisponibleRepository bancoDisponibleRepository;

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }


    @Override
    public ResponseEntity<List<BancoDisponible>> listarBancoDisponible() {
        List<BancoDisponible> listaBancoDisp = bancoDisponibleRepository.findAll();
        return listaBancoDisp.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaBancoDisp);
    }

    @Override
    public ResponseEntity<BancoDisponible> AgregarBancoDisponible(BancoDisponible bancoDisponible) {
        if (!esTextoValido(bancoDisponible.getNombre())) {
            throw new IllegalArgumentException("El nombre del banco solo debe contener letras.");
        }
        bancoDisponible.setEstado("Aprobado");
        return ResponseEntity.ok(bancoDisponibleRepository.save(bancoDisponible));
    }

    @Override
    public ResponseEntity<BancoDisponible> ActualizarBancoDisponible(BancoDisponible bancoDisponible, Long id) {
        return bancoDisponibleRepository.findById(id).map(actual -> {
            if (!esTextoValido(bancoDisponible.getNombre())) {
                throw new IllegalArgumentException("El nombre del banco solo debe contener letras.");
            }
            actual.setNombre(bancoDisponible.getNombre());
            return ResponseEntity.ok(bancoDisponibleRepository.save(actual));
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> EliminarBancoDisponible(Long id) {
        return bancoDisponibleRepository.findById(id).map(banco -> {
            banco.setEstado("Inactivo");
            bancoDisponibleRepository.save(banco);
            return ResponseEntity.ok("Banco inactivado correctamente.");
        }).orElse(ResponseEntity.notFound().build());
    }
}
