package com.challenge.ecommerce.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.ecommerce.modelo.Producto;
import com.challenge.ecommerce.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	//este metodo devolvera todos los productos
	public Iterable<Producto> obtenerProductos(){
		return productoRepositorio.findAll();
	}
	
}
