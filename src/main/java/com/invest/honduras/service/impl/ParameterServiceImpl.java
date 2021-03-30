package com.invest.honduras.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invest.honduras.dao.ParameterDao;
import com.invest.honduras.domain.map.ParameterMap;
import com.invest.honduras.domain.model.Parameter;
import com.invest.honduras.domain.model.Role;
import com.invest.honduras.domain.model.StateSolicitude;
import com.invest.honduras.domain.model.StateUser;
import com.invest.honduras.http.ParameterResponse;
import com.invest.honduras.service.ParameterService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	ParameterDao parameterDao;
	
	
	public Flux<Parameter> listAllParameter() {
		// TODO Auto-generated method stub
		return parameterDao.listAll();
	}
		
	public Mono<Parameter> parameterbyType(String typeParameter){
		// TODO Auto-generated method stub
		return parameterDao.listParameterbyType(typeParameter);
	}
	
	
	
	@Override
	public Flux<Role> listRoles() {
		// TODO Auto-generated method stub
		return parameterDao.listRoles();
	}

	@Override
	public Flux<StateUser> listStatesUser() {
		// TODO Auto-generated method stub
		return parameterDao.listStatesUser();
	}

	@Override
	public Flux<StateSolicitude> listStatesSolicitude() {
		// TODO Auto-generated method stub
		return parameterDao.listStatesSolicitude();
	}

	@Override
	public Mono<List<ParameterResponse>> listParameterbyType(String typeParameter) {
				
		// TODO Auto-generated method stub		
		return this.parameterbyType(typeParameter).map(parameter-> {
			
			List<ParameterResponse> listParameter = new ArrayList<ParameterResponse>() ;
			
			ParameterMap parameterMap  = new ParameterMap();
			
			parameterMap.mappingResponse(parameter, listParameter);
			
			if(listParameter.get(0).getGroup()!=null) {
								
				Parameter parameterInfo =parameterDao.listParameterType(listParameter.get(0).getGroup().getType());
												
				parameterMap.completeGroup(listParameter, parameterInfo);
                
			}							
															
			
			return listParameter; 
		});
	}


}
