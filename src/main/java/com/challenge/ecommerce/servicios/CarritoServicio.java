package com.challenge.ecommerce.servicios;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.challenge.ecommerce.dto.CarritoDto;
import com.challenge.ecommerce.modelo.Carrito;
import com.challenge.ecommerce.modelo.Usuario;
import com.challenge.ecommerce.repositorios.CarritoRepositorio;
import com.challenge.ecommerce.repositorios.UsuarioRepositorio;





@Service
public class CarritoServicio {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private CarritoRepositorio carritoRepositorio;
	
	
	public List<Carrito> getCarritosDeUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepositorio.findById(idUsuario).get();

		return usuario.getCarritos();
		
	}
	
	//este metodo guardara el carrito
	@Transactional
	public ResponseEntity<?> saveCarrito(CarritoDto carritoDto){
		
		//se busca el usuario en la BD al cual le corresponde el carrito
		Usuario usuario = usuarioRepositorio.findById(carritoDto.getIdUsuario()).get();

		//se guarda el carrito en la BD
		Carrito carrito = carritoRepositorio.save(carritoDto.getCarrito());
		//se agrega el carrito al usuario
		usuario.getCarritos().add(carrito);
		//se actualiza el usuario
		usuarioRepositorio.save(usuario);
		return new ResponseEntity<String>(new String("Carrito Guardado Correctamente"),
		HttpStatus.CREATED);
	}

}
