package com.invest.honduras.domain.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class ParameterBase {
    
	@ApiModelProperty(notes = "descripcion"  , example ="descripcion")
	private String description;
	
	@ApiModelProperty(notes = "codigo" , example ="codigo")
	private String code;
	
	@ApiModelProperty(notes = "nombre" , example ="nombre")
	
	private String name ;
}
