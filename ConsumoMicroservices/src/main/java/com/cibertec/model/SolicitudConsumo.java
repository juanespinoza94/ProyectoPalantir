package com.cibertec.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Solicitud_Consumo")
@Data
public class SolicitudConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Solicitud_Consumo")
    private Long id;

    @Column(name = "ID_Reserva")
    private Long idReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Item_Consumo")
    private ItemConsumo itemConsumo;

    @Column(name = "Cantidad")
    private Integer cantidad = 1;

    @Column(name = "Estado")
    private String estado = "Pendiente";

    @Column(name = "Fecha_Solicitud")
    private LocalDate fechaSolicitud;

    @PrePersist
    public void asignarFechaSolicitud() {
        this.fechaSolicitud = LocalDate.now();
    }

    @Column(name = "Fecha_Atencion")
    private LocalDateTime fechaAtencion;

    @Column(name = "Observaciones")
    private String observaciones;
}