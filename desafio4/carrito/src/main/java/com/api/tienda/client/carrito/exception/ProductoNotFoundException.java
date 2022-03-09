package com.api.tienda.client.carrito.exception;

public class ProductoNotFoundException extends RuntimeException{

    public ProductoNotFoundException(Long id){
        super("Feign :: No se pudo encontrar el producto con el id: " + id);
    }

}
