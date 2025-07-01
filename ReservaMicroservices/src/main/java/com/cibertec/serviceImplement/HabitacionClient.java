package com.cibertec.serviceImplement;

import com.cibertec.model.HabitacionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "HabitacionMicroservices")
public interface HabitacionClient {
    @GetMapping("/api/habitacion/disponibles")
    List<HabitacionDTO> obtenerDisponiblesPorTipoYEstado(
            @RequestParam("tipo") String tipo,
            @RequestParam("estado") String estado
    );
}
