package com.cibertec.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Item_Consumo")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ItemConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Item_Consumo")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private TipoItem tipo;

    @Column(name = "Precio_Venta")
    private Double precioVenta;

    @Column(name = "Tiene_Stock")
    private Boolean tieneStock = true;

    @Column(name = "Estado")
    private String estado = "Disponible";

    public enum TipoItem {
        Servicio,
        Producto
    }

    @OneToOne(mappedBy = "itemConsumo", cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(mappedBy = "itemConsumo", cascade = CascadeType.ALL)
    private List<VencimientoProducto> vencimientoProducto = new ArrayList<>();

}