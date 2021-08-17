package com.challenge.ecommerce.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.ecommerce.modelo.Carrito;

@Repository
public interface CarritoRepositorio extends CrudRepository<Carrito, Long>{

}
