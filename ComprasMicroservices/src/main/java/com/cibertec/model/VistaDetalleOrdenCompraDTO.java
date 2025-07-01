package com.cibertec.model;

public interface VistaDetalleOrdenCompraDTO {

	 Long getIdDetalle();
	    Long getIdOrden();
	    String getItem();
	    String getTipo();
	    Integer getCantidad();
	    Double getPrecioCompra();
	    Double getSubtotal();
}
