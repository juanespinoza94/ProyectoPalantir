package com.cibertec.service;

import com.cibertec.model.VistaPagosReserva;
import com.cibertec.model.VistaReservasPendientes;

import java.util.List;

public interface PagosVistaService {

    List<VistaPagosReserva> listarPagosReserva();
    List<VistaReservasPendientes> listarReservasPendientes();
}
