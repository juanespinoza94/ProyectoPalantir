package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Empleado_Servicio")
@Data
public class EmpleadoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empleado_Servicio")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_Solicitud_Consumo")
    private SolicitudConsumo solicitudConsumo;

    @Column(name = "ID_Empleado")
    private Long idEmpleado;
}