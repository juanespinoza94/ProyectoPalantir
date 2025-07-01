package com.cibertec.serviceImpl;

import com.cibertec.model.VistaPagosReserva;
import com.cibertec.model.VistaReservasPendientes;
import com.cibertec.repository.PagosVistaRepository;
import com.cibertec.service.PagosVistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosVistaServiceImpl implements PagosVistaService {

    @Autowired
    private PagosVistaRepository repo;
    @Override
    public List<VistaPagosReserva> listarPagosReserva() {
        return repo.obtenerPagosReserva();
    }

    @Override
    public List<VistaReservasPendientes> listarReservasPendientes() {
        return repo.obtenerReservasPendientes();
    }
}
