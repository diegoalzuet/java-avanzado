package com.interbanking.apivuelos.excepciones;

public class AvionNotFoundException extends  RuntimeException{
    public AvionNotFoundException(Long id){
        super("No se pudo encontrar el avion n°: " + id);
    }
}
