package com.invest.honduras.domain.model;


import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "role")
public class Role extends ParameterBase {
	
	@ApiModelProperty(notes = "privilegios asociados al rol")
	private List<Privilege> privileges;
	
}
