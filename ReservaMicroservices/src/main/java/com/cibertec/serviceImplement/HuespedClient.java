package com.cibertec.serviceImplement;

import com.cibertec.model.HuespedDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AuthMicroservice", contextId = "huespedClient", path = "/api/huespedes")
public interface HuespedClient {

    @GetMapping("/usuario/{idUsuario}")
    Long obtenerIdHuespedPorUsuario(@PathVariable Long idUsuario);

    @GetMapping("/documento/{numeroDocumento}")
    HuespedDTO obtenerHuespedPorDocumento(@PathVariable String numeroDocumento);

    @GetMapping("/{id}")
    HuespedDTO obtenerHuespedPorId(@PathVariable Long id);
}
