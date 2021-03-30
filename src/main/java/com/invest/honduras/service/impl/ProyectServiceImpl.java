package com.invest.honduras.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invest.honduras.dao.ProyectDao;
import com.invest.honduras.domain.model.AccessType;
import com.invest.honduras.domain.model.DocumentType;
import com.invest.honduras.domain.model.Fase;
import com.invest.honduras.domain.model.FaseOption;
import com.invest.honduras.domain.model.Rule;
import com.invest.honduras.domain.model.Step;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;
import com.invest.honduras.service.ProyectService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProyectServiceImpl implements ProyectService {

	@Autowired
	ProyectDao proyectDao;

    
	@Override
	public Mono<Rule> findbyName( String proyectName) {
		
		return proyectDao.findbyName(proyectName);
	}

	@Override
	public Mono<Boolean> autorizationOption(ProyectFaseOptionRequest proyectRequest) {

		return proyectDao.autorizationOption(proyectRequest).map( info-> {
			
			Boolean flag = false ;
    	
		List<Fase> listFase = info.getFases().stream()		
		.filter( fase -> fase.getCode().equals(proyectRequest.getPhase()))			
         .collect(Collectors.toList());
		

		for (FaseOption options : listFase.get(0).getPhaseOption()) {

			if(options.getCode().equals(proyectRequest.getFaseOption() )) {
				if(options.getRolesAuth().contains(proyectRequest.getRole())) {
					
					flag = true; 
					break ; 
				} 
			} 
		}

			
	    return flag;
		}
				).defaultIfEmpty(false);
		
	
		
	}

	@Override
	public Mono<Boolean> autorizationTypeOperation(ProyectTypeOperationRequest proyectRequest) {
		
        return proyectDao.autorizationTypeOperation(proyectRequest).map( info-> {
        	
        	Boolean flag = false ;
        	
			List<Fase> listFase = info.getFases().stream()		
			.filter( fase -> fase.getCode().equals(proyectRequest.getPhase()))			
             .collect(Collectors.toList());
			
			List<Step> listStep = listFase.get(0).getStep().stream().
			filter( step -> step.getCode().equals(proyectRequest.getStep()))
			.collect(Collectors.toList());
			
			for (Step step2 : listStep) {
				
				for (AccessType access : step2.getAccessType()) {
					if( access.getCode().equals(proyectRequest.getAccessType())){
						
						if(access.getRolesAuth().contains(proyectRequest.getRole())) {
							
							flag = true;
							break ;
						}
					}
				}
				
				
			}
				log.info("flag"+ flag);
	
		    return flag;
		    
	}
        
			).defaultIfEmpty(false);
	}

	
	@Override
	public Mono<Boolean> autorizationTypeDocument(ProyectTypeDocumentRequest proyectRequest) {

		return proyectDao.autorizationTypeDocument(proyectRequest).map( info-> {        	Boolean flag = false ;
        	Boolean flagDocument = false ;
        	
			List<Fase> listFase = info.getFases().stream()		
			.filter( fase -> fase.getCode().equals(proyectRequest.getPhase()))			
             .collect(Collectors.toList());
			
			List<Step> listStep = listFase.get(0).getStep().stream().
			filter( step -> step.getCode().equals(proyectRequest.getStep()))
			.collect(Collectors.toList());
			
			for (Step step2 : listStep) {
				
				
				for (DocumentType documentType : step2.getDocumentType()) {
					
					if(documentType.getCode().equals(proyectRequest.getDocumentType())) {
						
						flagDocument= true;
						for (AccessType access : documentType.getActionType()) {
							
							if( access.getCode().equals(proyectRequest.getTypeAction())){
								
								if(access.getRolesAuth().contains(proyectRequest.getRole())) {
									
									flag = true;
									break ;
								}
							}
							
						}

						
				
			}
					
					if(!flagDocument) {						
						log.info("search document associate");
						for (DocumentType documentAssociate : documentType.getDocumentTypeAssociated()) {
							
							if(documentAssociate.getCode().equals(proyectRequest.getDocumentType())) {
																
								for (AccessType access : documentAssociate.getActionType()) {
									
									if( access.getCode().equals(proyectRequest.getTypeAction())){
										
										if(access.getRolesAuth().contains(proyectRequest.getRole())) {
											log.info("document associate :" + access);
											flag = true;
											break ;
										}
									}
									
								}
								break;
							}
							
						}
						
						
					}
					
				
				}
				   
		  
			}
			  return flag;
			}).defaultIfEmpty(false);
	
	}



	
	public Mono<Fase> findbyCodeandFase( String code, String codeFase) {
		
		return proyectDao.findbyCodeandFase(code, codeFase).map( info -> {
						
			List<Fase> listFase = info.getFases().stream()		
			.filter( fase -> fase.getCode().equals(code))			
             .collect(Collectors.toList());
			
			 return listFase.get(0);
			
		});
	}
	
	
	
}
