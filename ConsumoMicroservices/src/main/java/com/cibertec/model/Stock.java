package com.cibertec.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Stock")
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Stock")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_Item_Consumo")
    @JsonIgnore
    private ItemConsumo itemConsumo;

    @Column(name = "Cantidad_Disponible")
    private Integer cantidadDisponible = 0;

    @Column(name = "Fecha_Ultima_Actualizacion")
    private LocalDate fechaUltimaActualizacion;

    @PrePersist
    public void asignarFechaUltimaActualizacion() {
        this.fechaUltimaActualizacion = LocalDate.now();
    }

    @PreUpdate
    public void actualizarFechaUltimaActualizacion() {
        this.fechaUltimaActualizacion = LocalDate.now();
    }

}