package com.cibertec.serviceImpl;

import com.cibertec.modelDTO.*;
import com.cibertec.repository.ReporteRepository;
import com.cibertec.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private ReporteRepository repo;

    @Override
    public List<VistaOcupacionActualDTO> listarVistaOcupacion() {
        return repo.obtenerVistaOcupacion();
    }

    @Override
    public KpiOcupacionActualDTO obtenerKpiOcupacion() {
        return repo.obtenerKpiOcupacion();
    }

    @Override
    public List<IngresosDiariosDTO> listarIngresosDiarios() {
        return repo.obtenerIngresosDiarios();
    }

    @Override
    public List<KpiIngresosMensualesDTO> listarIngresosMensuales() {
        return repo.obtenerKpiIngresosMensuales();
    }

    @Override
    public List<ServiciosMasUsadosDTO> listarServiciosMasUsados() {
        return repo.obtenerServiciosMasUsados();
    }

    @Override
    public List<TopServiciosSemanaDTO> listarTopServiciosSemana() {
        return repo.obtenerTopServiciosSemana();
    }

    @Override
    public List<ProductosMasConsumidosDTO> listarProductosMasConsumidos() {
        return repo.obtenerProductosMasConsumidos();
    }

    @Override
    public List<KpiProductosMesDTO> listarKpiProductosMes() {
        return repo.obtenerKpiProductosMes();
    }

    @Override
    public List<ReporteFinancieroDTO> listarReporteFinanciero() {
        return repo.obtenerReporteFinanciero();
    }

    @Override
    public List<ConsumoPorHabitacionDTO> listarConsumoPorHabitacion() {
        return repo.obtenerConsumoPorHabitacion();
    }

    @Override
    public List<GastoTotalHuespedDTO> listarGastoTotalPorHuesped() {
        return repo.obtenerGastoTotalPorHuesped();
    }

    @Override
    public KpiGastoPromedioHuespedDTO obtenerGastoPromedioPorHuesped() {
        return repo.obtenerKpiGastoPromedio();
    }

    @Override
    public KpiPromedioEstanciaDTO obtenerPromedioEstancia() {
        return repo.obtenerPromedioEstancia();
    }

    @Override
    public List<IngresosPorTipoHabitacionDTO> listarIngresosPorTipoHabitacion() {
        return repo.obtenerIngresosPorTipoHabitacion();
    }


}
