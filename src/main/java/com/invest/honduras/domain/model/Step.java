package com.invest.honduras.domain.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Step {

	@ApiModelProperty(notes = "nombre del paso" , example ="paso 4")
	private String name ;
	
	@ApiModelProperty(notes = "codigo del paso" , example ="paso_01_04")
	private String code;
	
	@ApiModelProperty(notes = "descripcion del paso" , example ="Documentación")
	private String description;
	
	private List<DocumentType> documentType;
	
	private List<AccessType> accessType;
}
