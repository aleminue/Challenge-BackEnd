package com.challenge.ecommerce.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Carrito {
	
	@Id
	@SequenceGenerator(name = "seq_carrito", sequenceName = "seq_carrito")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carrito")
	@Column(name="id_carrito")
	private Long idCarrito;
	
	private String estado;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Cordoba")
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name="tipo_carrito")
	private String tipoCarrito;
	
	@Column(name="precio_total")
	private Double precioTotal;
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<DetalleCarrito> detallesCarrito; 

}
