package com.invest.honduras.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "status_user")
public class StateUser extends ParameterBase {
	
}
