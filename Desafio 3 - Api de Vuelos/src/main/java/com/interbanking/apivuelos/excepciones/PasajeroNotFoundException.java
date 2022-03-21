package com.interbanking.apivuelos.excepciones;

public class PasajeroNotFoundException extends  RuntimeException{
    public PasajeroNotFoundException(Long id){
        super("No se pudo encontrar el Pasajero n°: " + id);
    }
}
