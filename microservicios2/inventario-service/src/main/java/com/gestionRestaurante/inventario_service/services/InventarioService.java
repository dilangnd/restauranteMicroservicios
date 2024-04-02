package com.gestionRestaurante.inventario_service.services;

import com.gestionRestaurante.inventario_service.repositories.InventarioRepository;
import com.gestionRestaurante.inventario_service.model.dtos.BaseResponse;
import com.gestionRestaurante.inventario_service.model.dtos.OrdenItemRequest;
import com.gestionRestaurante.inventario_service.model.entities.Inventario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public boolean isInStock(String sku) {
        var inventory = inventarioRepository.findBySku(sku);

        return inventory.filter(value -> value.getQuantity() > 0).isPresent(); // si está disponible.
    }

//    public BaseResponse irATienda() {
//        return inventarioRepository.save((Ingrediente) )
//    }

    public BaseResponse areInStock(List<OrdenItemRequest> orderItems) {

        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrdenItemRequest::getSku).toList();

        List<Inventario> inventarioList = inventarioRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var inventory = inventarioList.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if (inventory.isEmpty()) {
                errorList.add("El ingrediente con id " + orderItem.getSku() + " no exisste en el inventarrio");
            } else if (inventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("El producto con id:  " + orderItem.getSku() + " No es suficiente para la receta");
            }
        });

        return errorList.size() > 0 ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
