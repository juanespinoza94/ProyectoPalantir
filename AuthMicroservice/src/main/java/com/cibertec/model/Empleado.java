package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empleado")
    private Long id;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Fecha_Contratacion")
    private LocalDateTime fechaContratacion;
    @PrePersist
    public void asignarFechaContratacion() {
        this.fechaContratacion = LocalDateTime.now();
    }

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Numero_Documento", unique = true)
    private String numeroDocumento;

    @Column(name = "Estado")
    private String estado = "Activo";

    @ManyToOne
    @JoinColumn(name = "ID_Cargo")
    private Cargo cargo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;
}
