package com.cibertec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Detalle_Reserva")
@Data
public class DetalleReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Detalle_Reserva")
    private Long id;

    @Column(name = "ID_Reserva")
    private Long idReserva;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Item_Consumo")
    private ItemConsumo itemConsumo;

    @Column(name = "Cantidad")
    private Integer cantidad = 1;

    @Column(name = "Monto_Unitario")
    private Double montoUnitario;
    
    @Column(name = "Monto_Total", insertable = false, updatable = false)
    private Double montoTotal;
    
}