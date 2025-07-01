package com.cibertec.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemProveedorId implements Serializable {
    private Long idItemConsumo;
    private Long idProveedor;
}