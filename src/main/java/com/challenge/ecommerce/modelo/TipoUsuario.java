package com.challenge.ecommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class TipoUsuario {

	@Id
	@SequenceGenerator(name = "seq_tipousuario", sequenceName = "seq_tipousuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipousuario")
	@Column(name="id_tipo_usuario")
	private Long idTipoUsuario;
	
	private String nombre;
	
	private Double descuento;
}
