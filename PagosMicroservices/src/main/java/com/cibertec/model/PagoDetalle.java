package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "Pago_Detalle")
@Data
public class PagoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pago_Detalle")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Pago")
    private Pago pago;

    @Column(name = "ID_Detalle_Reserva")
    private Long idDetalleReserva;

    @Column(name = "Monto_Pagado", precision = 10, scale = 2)
    private BigDecimal montoPagado;
}
