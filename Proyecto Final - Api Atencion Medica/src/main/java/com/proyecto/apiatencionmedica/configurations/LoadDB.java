package com.proyecto.apiatencionmedica.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.proyecto.apiatencionmedica.entities.Role;
import com.proyecto.apiatencionmedica.entities.User;
import com.proyecto.apiatencionmedica.repositories.RoleRepository;
import com.proyecto.apiatencionmedica.repositories.UserRepository;

import java.util.Arrays;

@Configuration
public class LoadDB {

    @Bean
    CommandLineRunner initDB(UserRepository personalRepository, RoleRepository roleRepository){

        String password = "$2a$10$V/ytPioYtBjQX/oLdvAj8.9FcX0CNPhVIBAm9qocykPsdrObPMe46"; //1234

        User doctor = new User("doctor",password,true,null);
        User nurse = new User("nurse",password,true,null);
        User user = new User("user",password,true,null);

         return args -> roleRepository.saveAll(Arrays.asList(
                new Role(doctor, "ROLE_DOCTOR"),
                new Role(doctor, "ROLE_NURSE"),
                new Role(doctor, "ROLE_USER"),
                new Role(nurse, "ROLE_NURSE"),
                new Role(nurse, "ROLE_USER"),
                new Role(user, "ROLE_USER")));
    }
}
