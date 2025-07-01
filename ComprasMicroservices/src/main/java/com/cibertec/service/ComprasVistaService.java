package com.cibertec.service;

import com.cibertec.model.VistaOrdenCompraDTO;

import java.util.List;

import com.cibertec.model.VistaDetalleOrdenCompraDTO;
import com.cibertec.model.VistaProveedoresActivosDTO;

import com.cibertec.model.VistaOrdenesPorProveedorDTO;


public interface ComprasVistaService {

	List<VistaOrdenCompraDTO> listarVistaOrdenesCompra();
    List<VistaDetalleOrdenCompraDTO> listarVistaDetalleOrdenCompra();
    List<VistaProveedoresActivosDTO> listarVistaProveedoresActivos();
    List<VistaOrdenesPorProveedorDTO> listarVistaOrdenesPorProveedor();
}
