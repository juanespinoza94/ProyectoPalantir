package com.cibertec.service;

import com.cibertec.modelDTO.*;

import java.util.List;

public interface ReporteService {
    List<VistaOcupacionActualDTO> listarVistaOcupacion();
    KpiOcupacionActualDTO obtenerKpiOcupacion();
    List<IngresosDiariosDTO> listarIngresosDiarios();
    List<KpiIngresosMensualesDTO> listarIngresosMensuales();
    List<ServiciosMasUsadosDTO> listarServiciosMasUsados();
    List<TopServiciosSemanaDTO> listarTopServiciosSemana();
    List<ProductosMasConsumidosDTO> listarProductosMasConsumidos();
    List<KpiProductosMesDTO> listarKpiProductosMes();
    List<ReporteFinancieroDTO> listarReporteFinanciero();
    List<ConsumoPorHabitacionDTO> listarConsumoPorHabitacion();
    List<GastoTotalHuespedDTO> listarGastoTotalPorHuesped();
    KpiGastoPromedioHuespedDTO obtenerGastoPromedioPorHuesped();
    KpiPromedioEstanciaDTO obtenerPromedioEstancia();
    List<IngresosPorTipoHabitacionDTO> listarIngresosPorTipoHabitacion();

}
