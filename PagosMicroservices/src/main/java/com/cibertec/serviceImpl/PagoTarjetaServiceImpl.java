package com.cibertec.serviceImpl;

import com.cibertec.model.BancoDisponible;
import com.cibertec.model.PagoTarjeta;
import com.cibertec.repository.BancoDisponibleRepository;
import com.cibertec.repository.PagoTarjetaRepository;
import com.cibertec.service.PagoTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoTarjetaServiceImpl implements PagoTarjetaService {

    @Autowired
    private PagoTarjetaRepository pagoTarjetaRepository;

    @Autowired
    private BancoDisponibleRepository bancoDisponibleRepository;

    @Override
    public ResponseEntity<List<PagoTarjeta>> listarPagoTarjeta() {
        List<PagoTarjeta> pagoTarjetas = pagoTarjetaRepository.findAll();
        return pagoTarjetas.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(pagoTarjetas);
    }

    private String obtenerTipoTarjetaAleatorio() {
        return Math.random() < 0.5 ? "Visa" : "MasterCard";
    }

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }


    @Override
    public ResponseEntity<PagoTarjeta> AgregarPagoTarjeta(PagoTarjeta pagoTarjeta) {

        if (!esTextoValido(pagoTarjeta.getTitularTarjeta())) {
            throw new IllegalArgumentException("El titular de la tarjeta solo debe contener letras.");
        }

        BancoDisponible banco = bancoDisponibleRepository.obtenerBancoAleatorio();
        if (banco != null) {
            pagoTarjeta.setBanco(banco);
        }

        pagoTarjeta.setTipoTarjeta(obtenerTipoTarjetaAleatorio());
        pagoTarjeta.setFechaProcesamiento(LocalDateTime.now());
        pagoTarjeta.setEstadoTransaccion("Aprobado");

        String numero = pagoTarjeta.getNumeroTarjetaMascara();
        if (numero != null && numero.length() >= 4) {
            String enmascarado = "****-****-****-" + numero.substring(numero.length() - 4);
            pagoTarjeta.setNumeroTarjetaMascara(enmascarado);
        }

        PagoTarjeta nuevo = pagoTarjetaRepository.save(pagoTarjeta);
        return ResponseEntity.ok(nuevo);
    }

    @Override
    public ResponseEntity<?> EliminarPagoTarjeta(Long id) {
        return pagoTarjetaRepository.findById(id).map(pagoTarjeta -> {
            pagoTarjetaRepository.delete(pagoTarjeta);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
