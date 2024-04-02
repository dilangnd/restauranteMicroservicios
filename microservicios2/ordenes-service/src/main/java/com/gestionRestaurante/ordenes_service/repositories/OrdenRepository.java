package com.gestionRestaurante.ordenes_service.repositories;

import com.gestionRestaurante.ordenes_service.model.entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
