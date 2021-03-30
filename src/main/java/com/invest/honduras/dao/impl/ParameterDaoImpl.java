package com.invest.honduras.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.invest.honduras.dao.ParameterDao;
import com.invest.honduras.domain.model.Parameter;
import com.invest.honduras.domain.model.Role;
import com.invest.honduras.domain.model.StateSolicitude;
import com.invest.honduras.domain.model.StateUser;
import com.invest.honduras.repository.ParameterReactiveRepository;
import com.invest.honduras.repository.ParameterRepository;
import com.invest.honduras.repository.RoleRepository;
import com.invest.honduras.repository.StateSolicitudeRepository;
import com.invest.honduras.repository.StateUserRepository;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ParameterDaoImpl implements ParameterDao {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	StateUserRepository stateUserRepository;
	
	@Autowired
	StateSolicitudeRepository stateSolicitudeRepository;

	@Autowired
	ParameterReactiveRepository parameterReactiveRepository;

	@Autowired
	ParameterRepository parameterRepository;
	
	public Flux<Role> listRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	public Flux<StateUser> listStatesUser() {
		// TODO Auto-generated method stub
		return stateUserRepository.findAll();
				}

	@Override
	public Flux<StateSolicitude> listStatesSolicitude() {
		// TODO Auto-generated method stub
		return stateSolicitudeRepository.findAll();
	}

	
	@Override
	public Mono<Parameter> listParameterbyType(String typeParameter) {
		// TODO Auto-generated method stub
		return parameterReactiveRepository.findByCategoryParameter(typeParameter);
	}
	
	@Override
	public Parameter listParameterType(String typeParameter) {
		// TODO Auto-generated method stub
		return parameterRepository.findByCategoryParameter(typeParameter);
	}

	
	@Override
	public Flux<Parameter> listAll() {
		// TODO Auto-generated method stub
		return parameterReactiveRepository.findAll();
	}

}
