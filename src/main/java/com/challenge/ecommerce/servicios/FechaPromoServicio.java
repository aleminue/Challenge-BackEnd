package com.challenge.ecommerce.servicios;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.ecommerce.modelo.FechaPromocionable;
import com.challenge.ecommerce.repositorios.FechaPromoRepositorio;

@Service
public class FechaPromoServicio {

	@Autowired
	private FechaPromoRepositorio fechaPromoRepositorio;
	
	public FechaPromocionable esFechaPromocionable() throws ParseException {
		
		//se crea y formatea la fecha del dia
		SimpleDateFormat formateadorFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaPromocionable = formateadorFecha.parse(formateadorFecha.format(new Date()));
		
		//se invoca al metodo de hybernate que compara si la fecha es de promocion
		return fechaPromoRepositorio.findByFechaDesdeLessThanEqualAndFechaHastaGreaterThanEqual(fechaPromocionable, fechaPromocionable);

	}
}
