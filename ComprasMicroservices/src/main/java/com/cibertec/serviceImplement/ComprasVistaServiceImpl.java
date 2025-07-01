package com.cibertec.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.repository.ComprasVistaRepository;
import com.cibertec.service.ComprasVistaService;
import com.cibertec.model.VistaOrdenCompraDTO;
import com.cibertec.model.VistaDetalleOrdenCompraDTO;
import com.cibertec.model.VistaProveedoresActivosDTO;
import com.cibertec.model.VistaOrdenesPorProveedorDTO;

@Service
public class ComprasVistaServiceImpl implements ComprasVistaService {

	@Autowired
    private ComprasVistaRepository comprasvistarepository;
	
	@Override
    public List<VistaOrdenCompraDTO> listarVistaOrdenesCompra() {
        return comprasvistarepository.obtenerVistaOrdenesCompra();
    }

    @Override
    public List<VistaDetalleOrdenCompraDTO> listarVistaDetalleOrdenCompra() {
        return comprasvistarepository.obtenerVistaDetalleOrdenCompra();
    }

    @Override
    public List<VistaProveedoresActivosDTO> listarVistaProveedoresActivos() {
        return comprasvistarepository.obtenerVistaProveedoresActivos();
    }

    @Override
    public List<VistaOrdenesPorProveedorDTO> listarVistaOrdenesPorProveedor() {
        return comprasvistarepository.obtenerVistaOrdenesPorProveedor();
    }
}
