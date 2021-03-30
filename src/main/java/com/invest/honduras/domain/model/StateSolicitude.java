package com.invest.honduras.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "status_solicitude")
public class StateSolicitude extends ParameterBase {
	
}
