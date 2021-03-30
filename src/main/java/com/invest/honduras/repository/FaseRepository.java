package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.invest.honduras.domain.model.Rule;

import reactor.core.publisher.Mono;

public interface FaseRepository  extends ReactiveMongoRepository<Rule, String>{
	
  @Query("{code : ?0 }")  	 
  Mono<Rule> findByName(String name);
    
  @Query(value ="{ 'code' : ?0 , 'fases.code' : ?1, 'fases.phaseOption.code' : ?2 , "
  		+ "'fases.phaseOption.rolesAuth' : ?3 }", fields = "{ 'fases.phaseOption' : 1 }")
  
  Mono<Rule> findByNameandRoleandPhaseOption (String name ,String codeFase, String codefaseOption, String codeRole);
  

  @Query("{ 'code' : ?0 , 'fases.code' : ?1, 'fases.step.code' : ?2 ,"
	  		+ "'fases.step.documentType.code' : ?3 , 'fases.step.documentType.actionType.code' : ?4 , "
	  		+ "'fases.step.documentType.actionType.rolesAuth' : ?5 }")
	  
 Mono<Rule> findByNameandRoleandTypeDocument (String name ,String codeFase, String codeStep,
		  String codeDocumentType,String actionType, String role );

  
   @Query(value="{ 'code' : ?0 , 'fases.code' : ?1, 'fases.step.code' : ?2 } "
	  		 )
	  
   Mono<Rule> findByNameandRoleandTypeOperation(String name ,String codeFase, String codeStep); 
   

}
