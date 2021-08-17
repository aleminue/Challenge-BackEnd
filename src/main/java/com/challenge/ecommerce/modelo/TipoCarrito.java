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
public class TipoCarrito {

	@Id
	@SequenceGenerator(name = "seq_tipocarrito", sequenceName = "seq_tipocarrito")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipocarrito")
	@Column(name="id_tipo_carrito")
	private Long idTipoCarrito;
	
	private String nombre;
	
	private String descripcion;
	
}
