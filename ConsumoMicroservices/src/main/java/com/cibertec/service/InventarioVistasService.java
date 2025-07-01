package com.cibertec.service;

import com.cibertec.model.ProductoVencimientoDTO;
import com.cibertec.model.ProveedorItemDTO;
import com.cibertec.model.StockActualDTO;
import com.cibertec.model.StockProductoDTO;

import java.util.List;

public interface InventarioVistasService {
    List<StockActualDTO> listarStockActual();
    List<ProveedorItemDTO> listarProveedoresItems();
    List<StockProductoDTO> listarStockProductos();
    List<ProductoVencimientoDTO> listarProductosVencimiento();
}
