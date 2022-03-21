package com.api.tienda.client.producto.controller;

import com.api.tienda.client.producto.entity.ProductoEntity;
import com.api.tienda.client.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productos")
public class ProductorController {

    @Autowired
    private ProductoService productoService;

   @GetMapping("/{productoId}")
    ProductoEntity getProductoById(@PathVariable Long productoId){
       return productoService.getProductoById(productoId);
   }

   @GetMapping
    Iterable<ProductoEntity> getProductos(){
      return productoService.getProductos();
   }

   @PostMapping("/add")
    ProductoEntity addProducto(@RequestBody ProductoEntity producto){
       return productoService.addProducto(producto);
   }

   @DeleteMapping("/delete/{id}")
    void deleteProducto(@PathVariable Long id){
       productoService.deleteProducto(id);
   }
   @PutMapping("/update/{id}")
    ProductoEntity updateProducto(@PathVariable Long id, @RequestBody ProductoEntity productoNuevo){
       return productoService.updateProducto(id,productoNuevo);
   }

}
