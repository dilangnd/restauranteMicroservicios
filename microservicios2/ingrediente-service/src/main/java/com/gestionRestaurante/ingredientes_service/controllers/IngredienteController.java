package com.gestionRestaurante.ingredientes_service.controllers;

import com.gestionRestaurante.ingredientes_service.services.IngredienteService;
import com.gestionRestaurante.ingredientes_service.model.dtos.IngredienteRequest;
import com.gestionRestaurante.ingredientes_service.model.dtos.IngredienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody IngredienteRequest ingredienteRequest) {
        this.ingredienteService.addIngrediente(ingredienteRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IngredienteResponse> getAllProducts() {
        return this.ingredienteService.getAllIngredientes();
    }
}
