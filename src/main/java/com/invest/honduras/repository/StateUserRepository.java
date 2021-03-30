package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.invest.honduras.domain.model.StateUser;

public interface StateUserRepository  extends ReactiveMongoRepository<StateUser, String>{

}
