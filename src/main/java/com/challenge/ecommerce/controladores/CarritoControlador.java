package com.challenge.ecommerce.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ecommerce.dto.CarritoDto;
import com.challenge.ecommerce.modelo.Carrito;
import com.challenge.ecommerce.servicios.CarritoServicio;

@RestController
@RequestMapping(value = "/carritos")
public class CarritoControlador {

		//se inicializa un Logger para despues mostrar que esta pasando en consola
		private final static Logger logger = LoggerFactory.getLogger(CarritoControlador.class);
		
		@Autowired
		private CarritoServicio carritoServicio;
		
		//creacion del endpoint
		@RequestMapping(method = RequestMethod.GET, value = "/{idUsuario}")
		public ResponseEntity<?> getCarritos(@PathVariable(name = "idUsuario") Long idUsuario){
			try {
				//se llama al metodo getCarritosDeUsuario del servicio y si todo sale bien responde OK sino pasa al catch
				return new ResponseEntity<List<Carrito>>(carritoServicio.getCarritosDeUsuario(idUsuario), HttpStatus.OK);
			} catch (Exception e) {
				logger.error("getCarritos(): " + e.toString());
				return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.BAD_REQUEST);
			}
		}
		
		//creacion del endpoint
		@RequestMapping(method = RequestMethod.POST, value = "/nuevo")
		public ResponseEntity<?> saveCarrito (@RequestBody CarritoDto carritoDto){
			try {
				//se llama al metodo saveCarrito del servicio y si todo sale bien responde OK sino pasa al catch
				return carritoServicio.saveCarrito(carritoDto);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("getCarritos(): " + e.toString());
				return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.BAD_REQUEST);
			}
		}
		
		
	
}
