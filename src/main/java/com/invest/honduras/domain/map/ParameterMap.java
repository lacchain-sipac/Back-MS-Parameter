package com.invest.honduras.domain.map;

import java.util.ArrayList;
import java.util.List;

import com.invest.honduras.domain.model.Parameter;
import com.invest.honduras.domain.model.ParameterBase;
import com.invest.honduras.http.GroupElementResponse;
import com.invest.honduras.http.ParameterResponse;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class ParameterMap {

	public void mappingResponse(Parameter parameter,List<ParameterResponse> listParameterResponse ) {
						
		parameter.getParameters().forEach(ele -> {
			
			ParameterResponse parameterResponse = new ParameterResponse();
			
			parameterResponse.setCode(ele.getCode());
			parameterResponse.setDescription(ele.getDescription());			
			
			if(ele.getGroup()!=null) {
				
				GroupElementResponse groupElementResponse  = new GroupElementResponse();
				
				groupElementResponse.setType(ele.getGroup().getType());
				
				List<ParameterBase>  listParameterBase =new ArrayList<ParameterBase>();
				if(!ele.getGroup().getParameter().isEmpty()) {					
					ele.getGroup().getParameter().forEach(elegroup -> {
						ParameterBase parameterBase = new ParameterBase();
						parameterBase.setCode(elegroup);
						listParameterBase.add(parameterBase);	
					});					
					groupElementResponse.setParameter(listParameterBase);
					
				}
					parameterResponse.setGroup(groupElementResponse);
			}								
			
			
			
			listParameterResponse.add(parameterResponse);
			
		});
		
		
		
	}
	
	public void completeGroup(List<ParameterResponse> listParameterResponse, Parameter parameter) {

		listParameterResponse.forEach(elementResponse -> {
			log.info("elementResponse :" + elementResponse.getGroup().getParameter());
			parameter.getParameters().forEach( dataparameter -> {
				elementResponse.getGroup().getParameter().forEach( elementGroup -> {
					if(dataparameter.getCode().equals(elementGroup.getCode()) ) {
						elementGroup.setDescription(dataparameter.getDescription());
					}
					log.info("elementResponse :" + elementGroup);
				
				});

				
			});

		});

					

	}
}
