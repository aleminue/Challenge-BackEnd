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
public class Producto {

	@Id
	@SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto")
	@Column(name="id_producto")
	private Long idProducto;
	
	private String nombre;
	
	private String descripcion;
	
	private Double precio;
}
