package com.api.tienda.client.carrito.controller;

import com.api.tienda.client.carrito.entity.ProductoEntity;
import com.api.tienda.client.carrito.exception.ProductoNotFoundException;
import com.api.tienda.client.carrito.repository.FeignRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private FeignRepository feignRepository;

    @GetMapping
    List<ProductoEntity> getProductos(){
        return this.feignRepository.getProductos();
    }

    @GetMapping("/{productoId}")
    ProductoEntity getProductoById(@PathVariable Long productoId){
        try {
            return this.feignRepository.getProductoById(productoId);
        }catch (Exception ex){
            throw new ProductoNotFoundException(productoId);
        }
    }

    @PostMapping("/add")
    ProductoEntity addProducto(@RequestBody ProductoEntity producto){
        return this.feignRepository.addProducto(producto);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProducto(@PathVariable Long id){
        try{
            this.feignRepository.deleteProducto(id);
        }catch (Exception ex){
            throw  new ProductoNotFoundException(id);
        }
    }
    @PutMapping("/update/{id}")
    ProductoEntity updateProducto(@PathVariable Long id, @RequestBody ProductoEntity productoNuevo){
        return this.feignRepository.updateProducto(id,productoNuevo);
    }
}
