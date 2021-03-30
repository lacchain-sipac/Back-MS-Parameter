package com.invest.honduras.service;

import com.invest.honduras.domain.model.Rule;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;

import reactor.core.publisher.Mono;

public interface ProyectService {

	Mono<Rule> findbyName(String proyectName);
	
	Mono<Boolean>autorizationOption(ProyectFaseOptionRequest proyectRequest);
	
	Mono<Boolean> autorizationTypeOperation(ProyectTypeOperationRequest proyectRequest);
	
	Mono<Boolean> autorizationTypeDocument(ProyectTypeDocumentRequest proyectRequest);
}
