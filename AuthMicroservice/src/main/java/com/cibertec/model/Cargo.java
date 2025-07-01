package com.cibertec.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cargo")
    private Long id;
    @Column(name = "Descripcion")
    private String descripcion;
}