package com.invest.honduras.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClasificationType {

	@ApiModelProperty(notes = "codigo de clasificacion" , example ="doc_type_01040101")
	private String code;
	@ApiModelProperty(notes = "descripcion de la clasificacion" , example ="Documento")
	private String description;	
}
