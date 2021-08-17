package com.challenge.ecommerce.repositorios;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.challenge.ecommerce.modelo.FechaPromocionable;

@Repository
public interface FechaPromoRepositorio extends CrudRepository<FechaPromocionable, Long> {
	
	FechaPromocionable findByFechaDesdeLessThanEqualAndFechaHastaGreaterThanEqual(Date fechaDesde, Date fechaHasta);
	

	
	

}
