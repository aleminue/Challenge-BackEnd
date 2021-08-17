package com.challenge.ecommerce.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.ecommerce.modelo.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

}
