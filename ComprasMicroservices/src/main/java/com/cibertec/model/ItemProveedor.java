package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name = "Item_Proveedor")
@IdClass(ItemProveedorId.class)
@Data
public class ItemProveedor {

	  @Id
	    @Column(name = "ID_Item_Consumo")
	    private Long idItemConsumo;

	    @Id
	    @Column(name = "ID_Proveedor")
	    private Long idProveedor;

	    @Column(name = "Precio_Compra", precision = 10, scale = 2)
	    private BigDecimal precioCompra;

	    
	    @Column(name = "ID_Item_Consumo")
	    private Long itemConsumo;

	    @ManyToOne
	    @JoinColumn(name = "ID_Proveedor")
	    private Proveedor proveedor;
	}

