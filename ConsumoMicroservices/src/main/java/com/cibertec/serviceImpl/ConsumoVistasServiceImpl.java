package com.cibertec.serviceImpl;

import com.cibertec.model.*;
import com.cibertec.repository.ConsumoVistasRepository;
import com.cibertec.service.ConsumoVistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumoVistasServiceImpl implements ConsumoVistasService {

    @Autowired
    private ConsumoVistasRepository repo;

    @Override
    public List<SolicitudConsumoDTO> listarVistasSolicitudes() {
        return repo.obtenerSolicitudesConsumo();
    }

    @Override
    public List<SolicitudPendienteDTO> listarVistasPendientes() {
        return repo.obtenerSolicitudesPendientes();
    }

    @Override
    public List<ServicioProgramadoDTO> listarServiciosProgramados() {
        return repo.obtenerServiciosProgramados();
    }

    @Override
    public List<ServicioAsignadoDTO> listarServiciosAsignados() {
        return repo.obtenerServiciosAsignados();
    }

    @Override
    public List<HistorialSolicitudServicioDTO> listarHistorialSolicitudesServicio() {
        return repo.obtenerHistorialSolicitudesServicio();
    }

}
