package com.challenge.ecommerce.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.challenge.ecommerce.dto.UsuarioDto;
import com.challenge.ecommerce.modelo.Usuario;
import com.challenge.ecommerce.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	//metodo que devuelve si el usuario existe
	public ResponseEntity<?> obtenerUsuarioLogueado(UsuarioDto usuarioDto){
		//se verifica si el usuario ingresado existe en la BD
		if(usuarioRepositorio.existsByNombreIgnoreCaseAndContraIgnoreCase(usuarioDto.getUser(), usuarioDto.getPass())) {
			//si existe se devuelve el objeto usuario
			return new ResponseEntity<Usuario>( usuarioRepositorio.findByNombre(usuarioDto.getUser()), HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(new String("Usuario o Contraseña Incorrecta"), HttpStatus.OK);
	}
	
}
