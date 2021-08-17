package com.challenge.ecommerce.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.ecommerce.dto.UsuarioDto;
import com.challenge.ecommerce.servicios.UsuarioServicio;

@RestController
@RequestMapping(value = "/usuarioLogueado")
public class UsuarioControlador {

		//se inicializa un Logger para despues mostrar que esta pasando en consola
		private final static Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);
		
		@Autowired
		private UsuarioServicio usuarioServicio;
		
		//creacion del endpoint
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<?> getUsuarioLogueado(@RequestBody UsuarioDto usuario){
			try {
				//se llama al metodo obtenerUsuarioLogueado del servicio y si todo sale bien responde OK sino pasa al catch
				return usuarioServicio.obtenerUsuarioLogueado(usuario);
			} catch (Exception e) {
				logger.error("getUsuarioLogueado(): " + e.toString());
				return new ResponseEntity<String>(new String("Ocurrio un problema."), HttpStatus.BAD_REQUEST);
			}
		}
		
		
	
}
