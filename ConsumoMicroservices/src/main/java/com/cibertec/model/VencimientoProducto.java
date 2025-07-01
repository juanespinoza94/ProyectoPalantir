package com.cibertec.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Vencimiento_Producto")
@Data
public class VencimientoProducto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Vencimiento_Producto")
	private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Item_Consumo")
    @JsonIgnore
    private ItemConsumo itemConsumo;

    @Column(name = "Fecha_Vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "Alerta")
    private Boolean alerta = false;

}