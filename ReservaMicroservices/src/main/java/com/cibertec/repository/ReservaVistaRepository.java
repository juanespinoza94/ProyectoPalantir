package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cibertec.model.VistaDisponibilidadHabitacionDTO;
import com.cibertec.model.VistaHistorialReservasHuespedDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesDTO;
import com.cibertec.model.VistaReservasActivasDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesRecepcionistaDTO;
import com.cibertec.model.VistaCheckPendienteDTO;
import com.cibertec.model.VistaDetalleReservaDTO;
import com.cibertec.model.DummyEntity;

@Repository
public interface ReservaVistaRepository extends JpaRepository<DummyEntity, Long> {

    @Query(value = "SELECT * FROM vista_disponibilidad_habitacion", nativeQuery = true)
    List<VistaDisponibilidadHabitacionDTO> obtenerDisponibilidadHabitaciones();

    @Query(value = "SELECT * FROM vista_historial_reservas_huesped", nativeQuery = true)
    List<VistaHistorialReservasHuespedDTO> obtenerHistorialReservas();

    @Query(value = "SELECT * FROM vista_habitaciones_disponibles", nativeQuery = true)
    List<VistaHabitacionesDisponiblesDTO> obtenerHabitacionesDisponibles();

    @Query(value = "SELECT * FROM vista_reservas_activas", nativeQuery = true)
    List<VistaReservasActivasDTO> obtenerReservasActivas();

    @Query(value = "SELECT * FROM vista_habitaciones_disponibles_recepcionista", nativeQuery = true)
    List<VistaHabitacionesDisponiblesRecepcionistaDTO> obtenerHabitacionesRecepcionista();

    @Query(value = "SELECT * FROM vista_check_pendiente", nativeQuery = true)
    List<VistaCheckPendienteDTO> obtenerCheckPendiente();

    @Query(value = "SELECT * FROM vista_detalle_reserva", nativeQuery = true)
    List<VistaDetalleReservaDTO> obtenerDetalleReservas();
}
