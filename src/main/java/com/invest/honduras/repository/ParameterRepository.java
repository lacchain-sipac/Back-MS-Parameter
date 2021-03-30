package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.invest.honduras.domain.model.Parameter;

public interface ParameterRepository extends MongoRepository<Parameter, String>{

    @Query("{ 'typeParameter': ?0 }")
    Parameter findByCategoryParameter(String typeParameter);
    

}
