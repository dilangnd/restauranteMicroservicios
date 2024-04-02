package com.gestionRestaurante.ingredientes_service.services;

import com.gestionRestaurante.ingredientes_service.model.dtos.IngredienteRequest;
import com.gestionRestaurante.ingredientes_service.model.dtos.IngredienteResponse;
import com.gestionRestaurante.ingredientes_service.model.entities.Ingrediente;
import com.gestionRestaurante.ingredientes_service.repositories.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;
    Ingrediente ingrediente = new Ingrediente();
    public void addIngrediente(IngredienteRequest ingredienteRequest) { // o or a la tienda
        //volver a revisar el BaseResponse que parece deprecated o no compatible :/
        //Agrregar al inventario

        Ingrediente ingrediente = new Ingrediente().build()
                .post()
                .uri("https://microservices-utadeo-arq-fea471e6a9d4.herokuapp.com/api/v1/software-architecture/market-place")
                .bodyValue(ingredienteRequest.getIngredienteItems())
                .retrieve()
                .bodyToMono(ingrediente.class)
                .block();
        if (result != null && !result.hasErrors()) {
            Ingrediente ingrediente = new Ingrediente();
            orden.setIngredienteNumber(UUID.randomUUID().toString());
            orden.setIngredientesItems(ingredienteRequest.getClass().stream()
                    .map(ordenItemRequest -> mapOrderItemRequestToIngredienteItem(ingredienteRequest, ingrediente))
                    .toList());
            this.ingredienteRepository.save(ingrediente);
        } else {
            throw new IllegalArgumentException("Algunos ingredientes de la receta no estan disponibles");
        }

        log.info("Ingrediente agregado tras ir a la tienda: {}", ingrediente);
    }

    public List<IngredienteResponse> getAllIngredientes() {
        var products = ingredienteRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private IngredienteResponse mapToProductResponse(Ingrediente ingrediente) {
        return IngredienteResponse.builder()
                .id(ingrediente.getId())
                .sku(ingrediente.getSku())
                .name(ingrediente.getName())
                .description(ingrediente.getDescription())
                .status(ingrediente.getStatus())
                .build();
    }
}
