package com.gestionRestaurante.ordenes_service.model.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}
