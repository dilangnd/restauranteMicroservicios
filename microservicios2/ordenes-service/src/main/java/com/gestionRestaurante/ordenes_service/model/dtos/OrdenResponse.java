package com.gestionRestaurante.ordenes_service.model.dtos;

import java.util.List;


public record OrdenResponse(Long id, String orderNumber, List<OrdenItemsResponse> orderItems) {
}
