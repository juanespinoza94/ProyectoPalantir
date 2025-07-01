package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cibertec.model.DummyEntity;
import com.cibertec.model.VistaOrdenCompraDTO;
import com.cibertec.model.VistaDetalleOrdenCompraDTO;
import com.cibertec.model.VistaProveedoresActivosDTO;
import com.cibertec.model.VistaOrdenesPorProveedorDTO;

@Repository
public interface ComprasVistaRepository extends JpaRepository<DummyEntity, Long>{

	@Query(value = "SELECT * FROM vista_ordenes_compra", nativeQuery = true)
    List<VistaOrdenCompraDTO> obtenerVistaOrdenesCompra();

    @Query(value = "SELECT * FROM vista_detalle_orden_compra", nativeQuery = true)
    List<VistaDetalleOrdenCompraDTO> obtenerVistaDetalleOrdenCompra();

    @Query(value = "SELECT * FROM vista_proveedores_activos", nativeQuery = true)
    List<VistaProveedoresActivosDTO> obtenerVistaProveedoresActivos();

    @Query(value = "SELECT * FROM vista_ordenes_por_proveedor", nativeQuery = true)
    List<VistaOrdenesPorProveedorDTO> obtenerVistaOrdenesPorProveedor();
}
