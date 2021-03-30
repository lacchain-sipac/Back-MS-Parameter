package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.invest.honduras.domain.model.Rule;

import reactor.core.publisher.Mono;

public interface ProyectRepository  extends ReactiveMongoRepository<Rule, String>{
	
  @Query("{code : ?0 }")  	 
  Mono<Rule> findByName(String name);
    
  @Query(value ="{ 'code' : ?0 , 'fases.code' : ?1 }" , fields = "{ 'fases' : 1}" )	  
  Mono<Rule> findByCodeandFase (String name ,String codeFase);
    
  
  @Query(value ="{ 'code' : ?0 , 'fases.code' : ?1, 'fases.phaseOption.code' : ?2 } ")
  		
  
  Mono<Rule> findByNameandRoleandPhaseOption (String name ,String codeFase, String codefaseOption);
  

  @Query("{ 'code' : ?0 , 'fases.code' : ?1, 'fases.step.code' : ?2 }")
	  
 Mono<Rule> findByNameandRoleandTypeDocument (String name ,String codeFase, String codeStep);
  
   @Query(value="{ 'code' : ?0 , 'fases.code' : ?1, 'fases.step.code' : ?2 } "
	  		 )	  
   Mono<Rule> findByNameandRoleandTypeOperation(String name ,String codeFase, String codeStep); 
   

}
