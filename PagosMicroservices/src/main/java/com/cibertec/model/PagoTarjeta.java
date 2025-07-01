package com.cibertec.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pago_Tarjeta")
@Data
public class PagoTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pago_Tarjeta")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_Pago", nullable = false)
    private Pago pago;
    
    @Column(name = "Titular_Tarjeta")
    private String titularTarjeta;
    @Column(name = "Tipo_Tarjeta")
    private String tipoTarjeta;
    @Column(name = "Numero_Tarjeta_Mascara")
    private String numeroTarjetaMascara;
    @Column(name = "Codigo_Transaccion")
    private String codigoTransaccion;

    @ManyToOne
    @JoinColumn(name = "ID_Banco")
    private BancoDisponible banco;

    @Column(name = "Fecha_Procesamiento")
    private LocalDateTime fechaProcesamiento;

    @PrePersist
    public void asignarFechaProcesamiento() {
        this.fechaProcesamiento = LocalDateTime.now();
    }

    @Column(name = "Estado_Transaccion")
    private String estadoTransaccion = "Aprobado";
}