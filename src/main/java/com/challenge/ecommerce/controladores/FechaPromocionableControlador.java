package com.challenge.ecommerce.controladores;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ecommerce.modelo.FechaPromocionable;
import com.challenge.ecommerce.servicios.FechaPromoServicio;


@RestController
@RequestMapping(value="/fechaPromocionable")
public class FechaPromocionableControlador {
	
	//se inicializa un Logger para despues mostrar que esta pasando en consola
		private final static Logger logger = LoggerFactory.getLogger(FechaPromocionableControlador.class);

		@Autowired
		private FechaPromoServicio servicioFechaPromo;
		
		//creacion del EndPoint
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<?> esFechaPromocion() {
			try {
				//se llama al metodo esFechaPromocionable del servicio y si todo sale bien responde OK sino pasa al catch
				return new ResponseEntity<FechaPromocionable>(servicioFechaPromo.esFechaPromocionable(), HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("esFechaPromocion(): " + e.toString());
				return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.BAD_REQUEST);
			}
		}
	
}
