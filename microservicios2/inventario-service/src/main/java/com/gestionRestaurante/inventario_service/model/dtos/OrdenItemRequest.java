package com.gestionRestaurante.inventario_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenItemRequest {

    private Long id;
    private String sku;
    private Double price;
    private Long quantity;
}
