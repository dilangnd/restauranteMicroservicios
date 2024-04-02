package com.gestionRestaurante.ordenes_service.services;

import com.gestionRestaurante.ordenes_service.model.dtos.*;
import com.gestionRestaurante.ordenes_service.model.entities.Orden;
import com.gestionRestaurante.ordenes_service.model.entities.OrdenItems;
import com.gestionRestaurante.ordenes_service.repositories.OrdenRepository;
import com.gestionRestaurante.ordenes_service.model.dtos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrdenRequest ordenRequest) {

        //Check for inventory
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/api/inventario/in-stock")
                .bodyValue(ordenRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();
        if (result != null && !result.hasErrors()) {
            Orden orden = new Orden();
            orden.setOrderNumber(UUID.randomUUID().toString());
            orden.setOrdenItems(ordenRequest.getOrderItems().stream()
                    .map(ordenItemRequest -> mapOrderItemRequestToOrderItem(ordenItemRequest, orden))
                    .toList());
            this.ordenRepository.save(orden);
        } else {
            throw new IllegalArgumentException("Algunos ingredientes de la receta no estan disponibles");
        }
    }

    public List<OrdenResponse> getAllOrdenes() {
        List<Orden> ordenes = this.ordenRepository.findAll();

        return ordenes.stream().map(this::mapToOrderResponse).toList();

    }

    private OrdenResponse mapToOrderResponse(Orden orden) {
        return new OrdenResponse(orden.getId(), orden.getOrderNumber()
                , orden.getOrdenItems().stream().map(this::mapToOrderItemRequest).toList());
    }

    private OrdenItemsResponse mapToOrderItemRequest(OrdenItems ordenItems) {
        return new OrdenItemsResponse(ordenItems.getId(), ordenItems.getSku(), ordenItems.getPrice(), ordenItems.getQuantity());
    }

    private OrdenItems mapOrderItemRequestToOrderItem(OrdenItemRequest ordenItemRequest, Orden orden) {
        return OrdenItems.builder()
                .id(ordenItemRequest.getId())
                .sku(ordenItemRequest.getSku())
                .price(ordenItemRequest.getPrice())
                .quantity(ordenItemRequest.getQuantity())
                .orden(orden)
                .build();
    }
}
