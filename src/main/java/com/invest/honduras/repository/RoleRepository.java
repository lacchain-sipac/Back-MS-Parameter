package com.invest.honduras.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.invest.honduras.domain.model.Role;

public interface RoleRepository   extends ReactiveMongoRepository<Role, String>{

	
}
