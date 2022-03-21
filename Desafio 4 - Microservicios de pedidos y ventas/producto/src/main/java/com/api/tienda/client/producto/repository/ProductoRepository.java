package com.api.tienda.client.producto.repository;

import com.api.tienda.client.producto.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<ProductoEntity,Long> {

}
