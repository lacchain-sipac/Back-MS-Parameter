package com.invest.honduras.http;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProyectTypeOperationRequest {
		
	@NotNull
	@JsonProperty("code_proyect")
	@ApiModelProperty(notes = "codigo del proyecto" , example ="PRY_HONDURAS")
	private String codeProyect;		
	
	@NotNull
	@JsonProperty("code_phase")
	@ApiModelProperty(notes = "codigo de la fase" , example ="fase_02")
	private String phase;	
		
	@NotNull	
	@JsonProperty("code_step")
	@ApiModelProperty(notes = "codigo del paso", example ="paso_02_01")
	private String step;
		
	@NotNull	
	@JsonProperty("code_access_type")
	@ApiModelProperty(notes = "codigo del tipo de acceso" , example ="upload")
	private String AccessType;
	
	@NotNull
	@ApiModelProperty(notes = "rol" , example ="ROLE_ESP_ADQ")
	private String role;	
}
