package com.invest.honduras.dao;

import com.invest.honduras.domain.model.Rule;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;

import reactor.core.publisher.Mono;

public interface ProyectDao {
	
	Mono<Rule>autorizationOption(ProyectFaseOptionRequest proyectRequest);
	
	Mono<Rule> autorizationTypeOperation(ProyectTypeOperationRequest proyectRequest);
	
	Mono<Rule> autorizationTypeDocument(ProyectTypeDocumentRequest proyectRequest);
	
	Mono<Rule> findbyName(String name); 

	Mono<Rule> findbyCodeandFase(String code , String fase);
}
