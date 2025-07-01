package com.cibertec.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pago")
    private Long id;

    @Column(name = "Fecha_Pago")
    private LocalDateTime fechaPago;

    @PrePersist
    public void asignarFechaPago() {
        this.fechaPago = LocalDateTime.now();
    }

    @Column(name = "Metodo_Pago")
    private String metodoPago;

    @Column(name = "Monto", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "Estado")
    private String estado = "Pagado";

    @Column(name = "ID_Reserva")
    private Long idReserva;

}
