package com.interbanking.apivuelos.configuracion;

import com.interbanking.apivuelos.entidades.AvionEntity;
import com.interbanking.apivuelos.entidades.PasajeroEntity;
import com.interbanking.apivuelos.entidades.VueloEntity;
import com.interbanking.apivuelos.repositorio.AvionRepository;
import com.interbanking.apivuelos.repositorio.VueloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);
    @Bean
    CommandLineRunner initDB( VueloRepository vueloRepository){
        PasajeroEntity pasajero1 = new PasajeroEntity("Diego Alzuet","12345679",null);
        PasajeroEntity pasajero2 = new PasajeroEntity("Pepe Argento","987654312",null);
        PasajeroEntity pasajero3 = new PasajeroEntity("Marcelo Gallardo","09122018",null);
        List<PasajeroEntity> pasajeros = new ArrayList<>();

        return args -> {
//            log.info("Precargando: " + avionRepository.save(new AvionEntity(50,(new ArrayList<VueloEntity>()))));
//            log.info("Precargando: " + avionRepository.save(new AvionEntity(35,(new ArrayList<VueloEntity>()))));

            pasajeros.add(pasajero1);
            log.info("Precargando: " + vueloRepository.save(new VueloEntity(new Date(),
                    new Date(),
                    "Neuquen",
                    "Cordoba",
                    pasajeros,
                    new AvionEntity(100,null))));
            pasajeros.add(pasajero2);
            pasajeros.add(pasajero3);
            log.info("Precargando: " + vueloRepository.save(new VueloEntity(new Date(),new Date(),"Buenos Aires","Corrientes", null,new AvionEntity(200,null))));

        };
    }
}
