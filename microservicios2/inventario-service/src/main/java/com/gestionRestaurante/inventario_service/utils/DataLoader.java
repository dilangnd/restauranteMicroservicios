package com.gestionRestaurante.inventario_service.utils;

import com.gestionRestaurante.inventario_service.repositories.InventarioRepository;
import com.gestionRestaurante.inventario_service.model.entities.Inventario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final InventarioRepository inventarioRepository;


    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");
        if (inventarioRepository.findAll().size() == 0) {
            inventarioRepository.saveAll(
                    List.of(
                            Inventario.builder().sku("000001").quantity(10L).build(),
                            Inventario.builder().sku("000002").quantity(20L).build(),
                            Inventario.builder().sku("000003").quantity(30L).build(),
                            Inventario.builder().sku("000004").quantity(0L).build()
                    )
            );
        }
        log.info("Productos cargados.");
    }
}
