package com.gestionRestaurante.ingredientes_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ingrediente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private String description;
    private Boolean status;

    @Override
    public String toString() {
        return "Ingrediente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
