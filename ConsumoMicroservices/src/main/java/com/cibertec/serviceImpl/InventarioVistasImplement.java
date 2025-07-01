package com.cibertec.serviceImpl;

import com.cibertec.model.ProductoVencimientoDTO;
import com.cibertec.model.ProveedorItemDTO;
import com.cibertec.model.StockActualDTO;
import com.cibertec.model.StockProductoDTO;
import com.cibertec.repository.InventarioVistasRepository;
import com.cibertec.service.InventarioVistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioVistasImplement implements InventarioVistasService {

    @Autowired
    InventarioVistasRepository repo;

    @Override
    public List<StockActualDTO> listarStockActual() {
        return repo.obtenerStockActual();
    }

    @Override
    public List<ProveedorItemDTO> listarProveedoresItems() {
        return repo.obtenerProveedoresItems();
    }

    @Override
    public List<StockProductoDTO> listarStockProductos() {
        return repo.obtenerStockProductos();
    }

    @Override
    public List<ProductoVencimientoDTO> listarProductosVencimiento() {
        return repo.obtenerProductosVencimiento();
    }


}
