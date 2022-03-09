package com.api.tienda.client.producto.exception;

public class ProductoNotFoundException extends RuntimeException{

    public ProductoNotFoundException(Long id){
        super("No se pudo encontrar el producto con id: " + id);
    }
}
