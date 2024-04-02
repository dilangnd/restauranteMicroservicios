package com.gestionRestaurante.ordenes_service.controllers;

import com.gestionRestaurante.ordenes_service.model.dtos.OrdenRequest;
import com.gestionRestaurante.ordenes_service.model.dtos.OrdenResponse;
import com.gestionRestaurante.ordenes_service.model.entities.Orden;
import com.gestionRestaurante.ordenes_service.services.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orden")
@RequiredArgsConstructor
public class OrdenController {

    private final OrdenService ordenService;

    //recetas
    public void crearRecetas(){
        List<Orden> recetas = new ArrayList<>();
        Orden arrozPollo = new Orden();
        // arrozpollo.setIngrediente(1,"Potato"");
        // arrozpollo.setIngrediente(1,"Lemon");
        // arrozpollo.setIngrediente(1,"Rice");
        // arrozpollo.setIngrediente(1,"Ketchup");
        // arrozpollo.setIngrediente(1,"Lettuce");
        // arrozpollo.setIngrediente(1,"Onion");
        // arrozpollo.setIngrediente(1,"Cheese");
        // arrozpollo.setIngrediente(1,"Meat");
        // arrozpollo.setIngrediente(1,"Chicken");
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String recetaOrder(@RequestBody OrdenRequest ordenRequest) {
        crearRecetas();
        this.ordenService.placeOrder(ordenRequest);
        return "Receta hecha correctamente";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrdenResponse> getOrders() {
        return this.ordenService.getAllOrders();
    }
}
