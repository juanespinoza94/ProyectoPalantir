package com.cibertec.service;


import com.cibertec.model.*;

import java.util.List;

public interface ConsumoVistasService {
    List<SolicitudConsumoDTO> listarVistasSolicitudes();
    List<SolicitudPendienteDTO> listarVistasPendientes();
    List<ServicioProgramadoDTO> listarServiciosProgramados();
    List<ServicioAsignadoDTO> listarServiciosAsignados();
    List<HistorialSolicitudServicioDTO> listarHistorialSolicitudesServicio();
}
