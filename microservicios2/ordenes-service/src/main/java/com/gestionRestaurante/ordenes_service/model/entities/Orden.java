package com.gestionRestaurante.ordenes_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "ordenes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL)
    private List<OrdenItems> ordenItems;

}
