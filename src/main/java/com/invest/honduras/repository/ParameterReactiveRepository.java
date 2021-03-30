package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.invest.honduras.domain.model.Parameter;

import reactor.core.publisher.Mono;

public interface ParameterReactiveRepository extends ReactiveMongoRepository<Parameter, String>{

    @Query("{ 'typeParameter': ?0 }")
    Mono<Parameter> findByCategoryParameter(String typeParameter);
    

}
