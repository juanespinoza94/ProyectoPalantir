package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Huesped")
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Huesped")
    private Long id;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Correo")
    private String correo;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Fecha_Nac")
    private LocalDate fechaNacimiento;

    @Column(name = "Fecha_Reg")
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void asignarFechaRegistro() {
        this.fechaRegistro = LocalDateTime.now();
    }

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Numero_Documento", unique = true)
    private String numeroDocumento;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Estado")
    private String estado = "Activo";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;
}
