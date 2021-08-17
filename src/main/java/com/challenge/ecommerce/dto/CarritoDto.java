package com.challenge.ecommerce.dto;



import com.challenge.ecommerce.modelo.Carrito;


import lombok.Data;
import lombok.NoArgsConstructor;

//clase para transferencia de datos que tiene el mismo nombre de los atributos que en el front end
@NoArgsConstructor
@Data
public class CarritoDto {

	private Long idUsuario;
	
	private Carrito carrito;
	
}
