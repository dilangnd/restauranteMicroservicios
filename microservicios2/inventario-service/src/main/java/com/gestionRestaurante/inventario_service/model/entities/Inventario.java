package com.gestionRestaurante.inventario_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private Long quantity;
}
