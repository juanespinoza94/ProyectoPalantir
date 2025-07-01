package com.cibertec.repository;

import com.cibertec.modelDTO.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<DummyEntity, Long> {

    @Query(value = "SELECT * FROM vista_ocupacion_actual", nativeQuery = true)
    List<VistaOcupacionActualDTO> obtenerVistaOcupacion();

    @Query(value = "SELECT * FROM kpi_ocupacion_actual", nativeQuery = true)
    KpiOcupacionActualDTO obtenerKpiOcupacion();

    @Query(value = "SELECT * FROM vista_ingresos_diarios", nativeQuery = true)
    List<IngresosDiariosDTO> obtenerIngresosDiarios();

    @Query(value = "SELECT * FROM kpi_ingresos_mensuales", nativeQuery = true)
    List<KpiIngresosMensualesDTO> obtenerKpiIngresosMensuales();

    @Query(value = "SELECT * FROM vista_servicios_mas_usados", nativeQuery = true)
    List<ServiciosMasUsadosDTO> obtenerServiciosMasUsados();

    @Query(value = "SELECT * FROM kpi_top_servicios_semana", nativeQuery = true)
    List<TopServiciosSemanaDTO> obtenerTopServiciosSemana();

    @Query(value = "SELECT * FROM vista_productos_mas_usados", nativeQuery = true)
    List<ProductosMasConsumidosDTO> obtenerProductosMasConsumidos();

    @Query(value = "SELECT * FROM kpi_productos_consumidos_mes", nativeQuery = true)
    List<KpiProductosMesDTO> obtenerKpiProductosMes();

    @Query(value = "SELECT * FROM vista_reportes_financieros", nativeQuery = true)
    List<ReporteFinancieroDTO> obtenerReporteFinanciero();

    @Query(value = "SELECT * FROM vista_consumo_por_habitacion", nativeQuery = true)
    List<ConsumoPorHabitacionDTO> obtenerConsumoPorHabitacion();

    @Query(value = "SELECT * FROM vista_gasto_total_huesped", nativeQuery = true)
    List<GastoTotalHuespedDTO> obtenerGastoTotalPorHuesped();

    @Query(value = "SELECT * FROM kpi_gasto_promedio_por_huesped", nativeQuery = true)
    KpiGastoPromedioHuespedDTO obtenerKpiGastoPromedio();

    @Query(value = "SELECT * FROM kpi_promedio_estancia", nativeQuery = true)
    KpiPromedioEstanciaDTO obtenerPromedioEstancia();

    @Query(value = "SELECT * FROM kpi_ingresos_por_tipo_habitacion", nativeQuery = true)
    List<IngresosPorTipoHabitacionDTO> obtenerIngresosPorTipoHabitacion();

}


