package com.api.tienda.client.carrito.repository;

import com.api.tienda.client.carrito.entity.ProductoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("microservice-producto")
public interface FeignRepository {

    @RequestMapping("/productos")
    List<ProductoEntity> getProductos();

    @RequestMapping("/productos/{productoId}")
    ProductoEntity getProductoById(@PathVariable Long productoId);

    @RequestMapping("/productos/add")
    ProductoEntity addProducto(ProductoEntity producto);

    @DeleteMapping("/productos/delete/{id}")
    void deleteProducto(@PathVariable Long id);

    @PutMapping("/productos/update/{id}")
    ProductoEntity updateProducto(@PathVariable Long id,  ProductoEntity productoNuevo);

}
