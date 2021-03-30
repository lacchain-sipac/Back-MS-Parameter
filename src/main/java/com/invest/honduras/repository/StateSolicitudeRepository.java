package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.invest.honduras.domain.model.StateSolicitude;

public interface StateSolicitudeRepository  extends ReactiveMongoRepository<StateSolicitude, String>{

}
