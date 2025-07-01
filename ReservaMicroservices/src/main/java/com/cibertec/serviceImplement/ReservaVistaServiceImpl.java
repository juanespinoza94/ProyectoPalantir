package com.cibertec.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.repository.ReservaVistaRepository;
import com.cibertec.service.ReservaVistaService;
import com.cibertec.model.VistaDisponibilidadHabitacionDTO;
import com.cibertec.model.VistaHistorialReservasHuespedDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesDTO;
import com.cibertec.model.VistaReservasActivasDTO;
import com.cibertec.model.VistaHabitacionesDisponiblesRecepcionistaDTO;
import com.cibertec.model.VistaCheckPendienteDTO;
import com.cibertec.model.VistaDetalleReservaDTO;
@Service
public class ReservaVistaServiceImpl implements ReservaVistaService {


    @Autowired
    private ReservaVistaRepository reservavistarepository;

    @Override
    public List<VistaDisponibilidadHabitacionDTO> obtenerDisponibilidadHabitaciones() {
        return reservavistarepository.obtenerDisponibilidadHabitaciones();
    }

    @Override
    public List<VistaHistorialReservasHuespedDTO> obtenerHistorialReservas() {
        return reservavistarepository.obtenerHistorialReservas();
    }

    @Override
    public List<VistaHabitacionesDisponiblesDTO> obtenerHabitacionesDisponibles() {
        return reservavistarepository.obtenerHabitacionesDisponibles();
    }

    @Override
    public List<VistaReservasActivasDTO> obtenerReservasActivas() {
        return reservavistarepository.obtenerReservasActivas();
    }

    @Override
    public List<VistaHabitacionesDisponiblesRecepcionistaDTO> obtenerHabitacionesRecepcionista() {
        return reservavistarepository.obtenerHabitacionesRecepcionista();
    }

    @Override
    public List<VistaCheckPendienteDTO> obtenerCheckPendiente() {
        return reservavistarepository.obtenerCheckPendiente();
    }

    @Override
    public List<VistaDetalleReservaDTO> obtenerDetalleReservas() {
        return reservavistarepository.obtenerDetalleReservas();
    }
}
