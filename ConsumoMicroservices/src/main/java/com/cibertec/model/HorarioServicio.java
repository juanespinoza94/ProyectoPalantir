package com.cibertec.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "Horario_Servicio")
@Data
public class HorarioServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Horario_Servicio")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Solicitud_Consumo")
    private SolicitudConsumo solicitudConsumo;

    @Column(name = "Fecha")
    private LocalDate fecha;

    @Column(name = "Hora_Inicio")
    private LocalTime horaInicio;

    @Column(name = "Hora_Fin")
    private LocalTime horaFin;
}

