package com.cibertec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Banco_Disponibles")
@Data
public class BancoDisponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Banco")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Estado")
    private String estado = "Activo";
}
