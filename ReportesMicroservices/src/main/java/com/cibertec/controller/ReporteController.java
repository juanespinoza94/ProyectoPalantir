package com.cibertec.controller;

import com.cibertec.modelDTO.*;
import com.cibertec.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService service;

    @GetMapping("/ocupacion")
    public ResponseEntity<List<VistaOcupacionActualDTO>> listarOcupacion() {
        return ResponseEntity.ok(service.listarVistaOcupacion());
    }

    @GetMapping("/kpi-ocupacion")
    public ResponseEntity<KpiOcupacionActualDTO> obtenerKpi() {
        return ResponseEntity.ok(service.obtenerKpiOcupacion());
    }

    @GetMapping("/ingresos-diarios")
    public ResponseEntity<List<IngresosDiariosDTO>> ingresosDiarios() {
        return ResponseEntity.ok(service.listarIngresosDiarios());
    }

    @GetMapping("/ingresos-mensuales")
    public ResponseEntity<List<KpiIngresosMensualesDTO>> ingresosMensuales() {
        return ResponseEntity.ok(service.listarIngresosMensuales());
    }

    @GetMapping("/servicios-mas-usados")
    public ResponseEntity<List<ServiciosMasUsadosDTO>> serviciosMasUsados() {
        return ResponseEntity.ok(service.listarServiciosMasUsados());
    }

    @GetMapping("/top-servicios-semana")
    public ResponseEntity<List<TopServiciosSemanaDTO>> topServiciosSemana() {
        return ResponseEntity.ok(service.listarTopServiciosSemana());
    }

    @GetMapping("/productos-mas-consumidos")
    public ResponseEntity<List<ProductosMasConsumidosDTO>> productosMasConsumidos() {
        return ResponseEntity.ok(service.listarProductosMasConsumidos());
    }

    @GetMapping("/kpi-productos-mes")
    public ResponseEntity<List<KpiProductosMesDTO>> kpiProductosMes() {
        return ResponseEntity.ok(service.listarKpiProductosMes());
    }

    @GetMapping("/financieros")
    public ResponseEntity<List<ReporteFinancieroDTO>> listarFinancieros() {
        return ResponseEntity.ok(service.listarReporteFinanciero());
    }

    @GetMapping("/consumos-habitacion")
    public ResponseEntity<List<ConsumoPorHabitacionDTO>> listarConsumosHabitacion() {
        return ResponseEntity.ok(service.listarConsumoPorHabitacion());
    }

    @GetMapping("/gasto-total-huesped")
    public ResponseEntity<List<GastoTotalHuespedDTO>> gastoTotalHuesped() {
        return ResponseEntity.ok(service.listarGastoTotalPorHuesped());
    }

    @GetMapping("/kpi-gasto-promedio-huesped")
    public ResponseEntity<KpiGastoPromedioHuespedDTO> gastoPromedioHuesped() {
        return ResponseEntity.ok(service.obtenerGastoPromedioPorHuesped());
    }

    @GetMapping("/kpi-promedio-estancia")
    public ResponseEntity<KpiPromedioEstanciaDTO> promedioEstancia() {
        return ResponseEntity.ok(service.obtenerPromedioEstancia());
    }

    @GetMapping("/ingresos-por-tipo-habitacion")
    public ResponseEntity<List<IngresosPorTipoHabitacionDTO>> ingresosPorTipoHabitacion() {
        return ResponseEntity.ok(service.listarIngresosPorTipoHabitacion());
    }


}