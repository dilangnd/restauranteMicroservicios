package com.gestionRestaurante.ordenes_service.model.dtos;

public record OrdenItemsResponse(Long id, String sku, Double price, Long quantity) {
}
