package com.interbanking.apivuelos.excepciones;

public class VueloNotFoundException extends  RuntimeException{
    public VueloNotFoundException(Long id){
        super("No se pudo encontrar el vuelo n°: " + id);
    }
}
