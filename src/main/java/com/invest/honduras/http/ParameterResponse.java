package com.invest.honduras.http;


import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class ParameterResponse {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "descripcion del parametro" , example ="Proyecto Integral de Desarrollo Rural y Productividad")
	private String description;	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "codigo del parametro" , example ="4940/BL-HO")
	private String code;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@ApiModelProperty(notes = "grupo element asociado al parametro" )
	private GroupElementResponse  group;
	
}
