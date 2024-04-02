package com.gestionRestaurante.inventario_service.controllers;

import com.gestionRestaurante.inventario_service.model.dtos.BaseResponse;
import com.gestionRestaurante.inventario_service.model.dtos.OrdenItemRequest;
import com.gestionRestaurante.inventario_service.services.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService inventarioService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku) {
        return inventarioService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK) // el ok, es que si lo tiene en stock pa la receta
    public BaseResponse areInStock(@RequestBody List<OrdenItemRequest> orderItems) {
        return inventarioService.areInStock(orderItems);
    }


    //Aqui debería ejecutar la consulta a la api del profe
//    @PostMapping("/ir-a-tienda")
//    @ResponseStatus(HttpStatus.OK)
//    public irATienda(List<OrderItemRequest> orderItems) {
//        return inventarioService.buyItems();
//    }
}
