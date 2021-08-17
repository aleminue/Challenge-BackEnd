package com.challenge.ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

//clase para transferencia de datos que tiene el mismo nombre de los atributos que en el front end
@NoArgsConstructor
@Data
public class UsuarioDto {
	
	private String user;
	
	private String pass;
}
