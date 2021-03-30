package com.invest.honduras.service;

import java.util.List;

import com.invest.honduras.domain.model.Role;
import com.invest.honduras.domain.model.StateSolicitude;
import com.invest.honduras.domain.model.StateUser;
import com.invest.honduras.http.ParameterResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParameterService {

	Flux<Role> listRoles();
	Flux<StateUser> listStatesUser();
	Flux<StateSolicitude> listStatesSolicitude();
	Mono<List<ParameterResponse>> listParameterbyType(String typeparameter);	
}
