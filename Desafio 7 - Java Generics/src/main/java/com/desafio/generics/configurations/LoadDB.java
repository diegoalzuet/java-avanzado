package com.desafio.generics.configurations;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.desafio.generics.impl.entity.Personal;
import com.desafio.generics.impl.entity.Rol;
import com.desafio.generics.impl.repository.PersonalRepository;
import com.desafio.generics.impl.repository.RolRepository;


import java.util.Arrays;


@Configuration
public class LoadDB {

    @Bean
    CommandLineRunner initDB(PersonalRepository personalRepository, RolRepository rolRepository){

        String password = "$2a$10$V/ytPioYtBjQX/oLdvAj8.9FcX0CNPhVIBAm9qocykPsdrObPMe46"; //1234

        Personal admin = new Personal("admin",password,true,null);        
        Personal user = new Personal("user",password,true,null);

         return args -> rolRepository.saveAll(Arrays.asList(
                new Rol(admin, "ROLE_ADMIN"),
                new Rol(admin, "ROLE_USER"),
                new Rol(user, "ROLE_USER")));
    }
}
