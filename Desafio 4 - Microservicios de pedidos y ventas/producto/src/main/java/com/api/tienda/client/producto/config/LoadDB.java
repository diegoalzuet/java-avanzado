package com.api.tienda.client.producto.config;

import com.api.tienda.client.producto.entity.ProductoEntity;
import com.api.tienda.client.producto.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDB(ProductoRepository productoRepository){
        return args -> {
            log.info("Pregarcando: " + productoRepository.save(new ProductoEntity("Zapatillas",250)));
            log.info("Pregarcando: " + productoRepository.save(new ProductoEntity("Remera",90)));
            log.info("Pregarcando: " + productoRepository.save(new ProductoEntity("Gorra",70)));
            log.info("Pregarcando: " + productoRepository.save(new ProductoEntity("Short",150)));
        };
    }
}
