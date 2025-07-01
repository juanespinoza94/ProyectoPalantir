package com.cibertec.repository;

import com.cibertec.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumoVistasRepository extends JpaRepository<DummyEntity, Long> {

    @Query(value = "SELECT * FROM vista_solicitudes_consumo", nativeQuery = true)
    List<SolicitudConsumoDTO> obtenerSolicitudesConsumo();

    @Query(value = "SELECT * FROM vista_solicitudes_pendientes", nativeQuery = true)
    List<SolicitudPendienteDTO> obtenerSolicitudesPendientes();

    @Query(value = "SELECT * FROM vista_servicios_programados", nativeQuery = true)
    List<ServicioProgramadoDTO> obtenerServiciosProgramados();

    @Query(value = "SELECT * FROM vista_servicios_asignados", nativeQuery = true)
    List<ServicioAsignadoDTO> obtenerServiciosAsignados();

    @Query(value = "SELECT * FROM vista_historial_solicitudes_servicio", nativeQuery = true)
    List<HistorialSolicitudServicioDTO> obtenerHistorialSolicitudesServicio();
}

