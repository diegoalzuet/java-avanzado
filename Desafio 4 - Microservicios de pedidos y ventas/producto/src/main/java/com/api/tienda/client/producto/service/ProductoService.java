package com.api.tienda.client.producto.service;

import com.api.tienda.client.producto.entity.ProductoEntity;
import com.api.tienda.client.producto.exception.ProductoNotFoundException;
import com.api.tienda.client.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoEntity getProductoById(Long id){
        return productoRepository.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
    }
    public Iterable<ProductoEntity> getProductos(){
        return productoRepository.findAll();
    }

    public ProductoEntity addProducto(ProductoEntity producto){
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id){
        try{
            productoRepository.deleteById(id);
        }catch (Exception ex){
            throw new ProductoNotFoundException(id);
        }
    }
    public ProductoEntity updateProducto(Long id,ProductoEntity productoNuevo){
        return productoRepository.findById(id)
                .map(productoActualizar ->{
                    productoActualizar.setDescripcion(productoNuevo.getDescripcion());
                    productoActualizar.setStock(productoNuevo.getStock());
                    return productoRepository.save(productoActualizar);
                }).orElseGet(() -> productoRepository.save(productoNuevo));
    }

}
