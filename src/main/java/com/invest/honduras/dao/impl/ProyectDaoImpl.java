package com.invest.honduras.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.invest.honduras.dao.ProyectDao;
import com.invest.honduras.domain.model.Rule;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;
import com.invest.honduras.repository.ProyectRepository;

import reactor.core.publisher.Mono;

@Component
public class ProyectDaoImpl implements ProyectDao {

	@Autowired
	ProyectRepository proyectRepository;


	@Override
	public Mono<Rule> findbyName(String name) {
		return proyectRepository.findByName(name);
	}
	
	
	@Override
	public Mono<Rule> autorizationOption(ProyectFaseOptionRequest proyectRequest) {
		return proyectRepository.findByNameandRoleandPhaseOption(proyectRequest.getCodeProyect(), proyectRequest.getPhase(),
				proyectRequest.getFaseOption());
	}

	@Override
	public Mono<Rule> autorizationTypeOperation(ProyectTypeOperationRequest proyectRequest){

		return proyectRepository.findByNameandRoleandTypeOperation(proyectRequest.getCodeProyect(), proyectRequest.getPhase(),
				proyectRequest.getStep());
	}
	

	@Override
	public Mono<Rule> autorizationTypeDocument(ProyectTypeDocumentRequest proyectRequest) {
		return proyectRepository.findByNameandRoleandTypeDocument(proyectRequest.getCodeProyect(), proyectRequest.getPhase(),
				proyectRequest.getStep());
	}


	@Override
	public Mono<Rule> findbyCodeandFase(String code, String fase) {
		return proyectRepository.findByCodeandFase(code, fase);
	}

}
