package com.cibertec.serviceImplement;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AuthMicroservice", contextId = "empleadoClient")
public interface EmpleadoClient {

    @GetMapping("/api/empleados/usuario/{idUsuario}")
    Long obtenerIdEmpleadoPorUsuario(@PathVariable("idUsuario") Long idUsuario);
}