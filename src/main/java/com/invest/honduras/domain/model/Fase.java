package com.invest.honduras.domain.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Fase {

	@ApiModelProperty(notes = "nombre de la fase" , example ="fase 1")
	private String name;
	
	@ApiModelProperty(notes = "codigo de la fase" , example ="fase_01")
	private String code;
	
	@ApiModelProperty(notes = "descripcion de  la fase" , example ="fase de solicitudes")
	private String description;
	
	@ApiModelProperty(notes = "pasos de la fase")	
	private List<Step> step;
	
	@ApiModelProperty(notes = "opciones de la fase")	
	private List<FaseOption> phaseOption;
}
