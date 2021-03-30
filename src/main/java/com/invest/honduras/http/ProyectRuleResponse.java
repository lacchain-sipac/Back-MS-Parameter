package com.invest.honduras.http;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProyectRuleResponse {
	
	@ApiModelProperty(notes = "autorizacion" , example ="true")
	private Boolean auth;	
}
