package com.gestionRestaurante.ordenes_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRequest {
    private List<OrdenItemRequest> orderItems;
}
