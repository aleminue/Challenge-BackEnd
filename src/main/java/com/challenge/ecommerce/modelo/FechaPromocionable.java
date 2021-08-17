package com.challenge.ecommerce.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class FechaPromocionable {
	
	@Id
	@SequenceGenerator(name = "seq_fechapromocionable", sequenceName = "seq_fechapromocionable")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fechapromocionable")
	@Column(name="id_fechaPromocionable")
	private Long idFechaPromocionable;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Cordoba")
	@Column(name="fecha_desde")
	private Date fechaDesde;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Cordoba")
	@Column(name="fecha_hasta")
	private Date fechaHasta;
	
	private Double descuento;
	
	private String descripcion;

}
