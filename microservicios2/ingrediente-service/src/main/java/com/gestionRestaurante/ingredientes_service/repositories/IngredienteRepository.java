package com.gestionRestaurante.ingredientes_service.repositories;

import com.gestionRestaurante.ingredientes_service.model.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
