package com.cibertec.repository;

import com.cibertec.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioVistasRepository extends JpaRepository<DummyEntity, Long> {
    @Query(value = "SELECT * FROM vista_stock_actual", nativeQuery = true)
    List<StockActualDTO> obtenerStockActual();

    @Query(value = "SELECT * FROM vista_proveedores_items", nativeQuery = true)
    List<ProveedorItemDTO> obtenerProveedoresItems();

    @Query(value = "SELECT * FROM vista_stock_productos", nativeQuery = true)
    List<StockProductoDTO> obtenerStockProductos();

    @Query(value = "SELECT * FROM vista_productos_vencimiento", nativeQuery = true)
    List<ProductoVencimientoDTO> obtenerProductosVencimiento();
}
