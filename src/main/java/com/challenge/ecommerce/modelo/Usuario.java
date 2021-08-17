package com.challenge.ecommerce.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@Column(name="id_usuario")
	private Long idUsuario;
	
	private String nombre;
	
	private String contra;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private TipoUsuario tipoUsuario;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER )
	private List<Carrito> carritos;

}
