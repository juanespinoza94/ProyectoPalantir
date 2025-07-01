package com.cibertec.serviceImpl;

import com.cibertec.model.DetalleReservaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ConsumoMicroservices")
public interface DetalleReservaClient {

    @GetMapping("/api/detalleReserva/detalle/{id}")
    DetalleReservaDTO obtenerDetallePorId(@PathVariable("id") Long id);
}
