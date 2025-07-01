package com.cibertec.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Detalle_Orden")
@Data
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Detalle")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Orden")
    private OrdenCompra ordencompra;

    
    @Column(name = "ID_Item_Consumo")
    private Long itemConsumo;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Precio_Compra", precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @Column(name = "Subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;
}