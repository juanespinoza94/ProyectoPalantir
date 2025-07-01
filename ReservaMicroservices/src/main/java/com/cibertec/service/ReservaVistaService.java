package com.cibertec.service;

import java.util.List;

import com.cibertec.model.VistaDisponibilidadHabitacionDTO;
import com.cibertec.model.VistaHistorialReservasHuespedDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesDTO;
import com.cibertec.model.VistaReservasActivasDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesRecepcionistaDTO;
import com.cibertec.model.VistaCheckPendienteDTO;
import com.cibertec.model.VistaDetalleReservaDTO;
public interface ReservaVistaService {

    List<VistaDisponibilidadHabitacionDTO> obtenerDisponibilidadHabitaciones();

    List<VistaHistorialReservasHuespedDTO> obtenerHistorialReservas();

    List<VistaHabitacionesDisponiblesDTO> obtenerHabitacionesDisponibles();

    List<VistaReservasActivasDTO> obtenerReservasActivas();

    List<VistaHabitacionesDisponiblesRecepcionistaDTO> obtenerHabitacionesRecepcionista();

    List<VistaCheckPendienteDTO> obtenerCheckPendiente();

    List<VistaDetalleReservaDTO> obtenerDetalleReservas();
}
