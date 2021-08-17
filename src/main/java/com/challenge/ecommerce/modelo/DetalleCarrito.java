package com.challenge.ecommerce.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class DetalleCarrito {

	@Id
	@SequenceGenerator(name = "seq_detalle_carrito", sequenceName = "seq_detalle_carrito")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_carrito")
	@Column(name="id_detalle_carrito")
	private Long idDetalleCarrito;
	
	@Column(name ="cantidad_producto")
	private Integer cantidadProducto;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE)
	private Producto producto;
	
}
