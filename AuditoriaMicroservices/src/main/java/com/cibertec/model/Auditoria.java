package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Audit_Log")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Audit")
    private Long id;

    @Column(name = "ID_Empleado")
    private Long idEmpleado;

    @Column(name = "Fecha")
    private LocalDateTime fecha;
    @PrePersist
    public void asignarFecha() {
        this.fecha = LocalDateTime.now();
    }

    @Column(name = "Accion")
    private String accion;

    @Column(name = "Tabla_Afectada")
    private String tablaAfectada;

    @Column(name = "ID_Registro")
    private Long idRegistro;

    @Column(name = "Descripcion")
    private String descripcion;
}
