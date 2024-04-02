package com.gestionRestaurante.inventario_service.repositories;

import com.gestionRestaurante.inventario_service.model.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findBySku(String sku); // es igual que id

    List<Inventario> findBySkuIn(List<String> skus);
}
