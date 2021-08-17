package com.challenge.ecommerce.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ecommerce.modelo.Producto;
import com.challenge.ecommerce.servicios.ProductoServicio;


@RestController
@RequestMapping(value = "/productos")
public class ProductoControlador {

	//se inicializa un Logger para despues mostrar que esta pasando en consola
	private final static Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

	@Autowired
	private ProductoServicio servicioProducto;
	
	//creacion del EndPoint
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getProductos() {
		try {
			//se llama al metodo obtenerProducto del servicio y si todo sale bien responde OK sino pasa al catch
			return new ResponseEntity<Iterable<Producto>>(servicioProducto.obtenerProductos(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("getProductos(): " + e.toString());
			return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.BAD_REQUEST);
		}
	}
	
}
