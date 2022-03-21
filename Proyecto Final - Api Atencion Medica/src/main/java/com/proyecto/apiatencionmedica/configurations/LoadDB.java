package com.proyecto.apiatencionmedica.configurations;

import com.proyecto.apiatencionmedica.entities.Personal;
import com.proyecto.apiatencionmedica.entities.Rol;
import com.proyecto.apiatencionmedica.repositories.PersonalRepository;
import com.proyecto.apiatencionmedica.repositories.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadDB {

    @Bean
    CommandLineRunner initDB(PersonalRepository personalRepository, RolRepository rolRepository){

        String password = "$2a$10$V/ytPioYtBjQX/oLdvAj8.9FcX0CNPhVIBAm9qocykPsdrObPMe46"; //1234

        Personal personalCaso1 = new Personal("admin",password,true,null);
        Personal personalCaso2 = new Personal("employee",password,true,null);
        Personal personalCaso3 = new Personal("user",password,true,null);

         return args -> rolRepository.saveAll(Arrays.asList(
                new Rol(personalCaso1, "ROLE_ADMIN"),
                new Rol(personalCaso1, "ROLE_EMPLOYEE"),
                new Rol(personalCaso1, "ROLE_USER"),
                new Rol(personalCaso2, "ROLE_EMPLOYEE"),
                new Rol(personalCaso2, "ROLE_USER"),
                new Rol(personalCaso3, "ROLE_USER")));
    }
}
