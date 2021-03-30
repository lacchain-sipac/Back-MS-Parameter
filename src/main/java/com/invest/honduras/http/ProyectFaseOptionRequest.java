package com.invest.honduras.http;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectFaseOptionRequest {

	@NotNull
	@JsonProperty("code_proyect")
	
	@ApiModelProperty(notes = "codigo del proyecto" , example ="PRY_HONDURAS")
	private String codeProyect;
	
	@NotNull
	@JsonProperty("code_phase")
	@ApiModelProperty(notes = "codigo de la fase del proyecto" , example ="fase_01")
	private String phase;
	
	@NotNull
	@ApiModelProperty(notes = "rol" , example ="ROL_ESP_ADQ")
	private String role;
	
	@NotNull
	@JsonProperty("code_phase_option")
	@ApiModelProperty(notes = "opcion de la fase del proyecto" , example ="fase_option_01_02")
	private String faseOption;
}
