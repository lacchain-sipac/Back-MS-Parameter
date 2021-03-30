package com.invest.honduras.dao;

import com.invest.honduras.domain.model.Parameter;
import com.invest.honduras.domain.model.Role;
import com.invest.honduras.domain.model.StateSolicitude;
import com.invest.honduras.domain.model.StateUser;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParameterDao {

	Flux<Role> listRoles();
	Flux<StateUser> listStatesUser();
	Flux<StateSolicitude>  listStatesSolicitude();
	Flux<Parameter> listAll();
	Mono<Parameter> listParameterbyType(String typeParameter);
	Parameter listParameterType(String typeParameter);
}
