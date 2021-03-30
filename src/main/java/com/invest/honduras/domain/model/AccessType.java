package com.invest.honduras.domain.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AccessType {

	@ApiModelProperty(notes = "codigo del tipo de acceso" ,example ="upload")
	private String code;
	
	@ApiModelProperty(notes = "descripcion del tipo de acceso", example ="upload")
	private String name;
	
	@ApiModelProperty(notes = "roles autorizados" , example = "ROLE_COO_TEC")
	private List<String> rolesAuth;
}
