package com.challenge.ecommerce.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.ecommerce.modelo.Usuario;


@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

	//retorno un booleano si existe el usuario y contraseña en la BD
	 Boolean existsByNombreIgnoreCaseAndContraIgnoreCase(String user, String pass);
	
	//retorna el usuario con el nombre indicado
	 Usuario findByNombre(String nombre);
	
}
