package com.invest.honduras.domain.model;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "rules")
public class Rule {

	@ApiModelProperty(notes = "nombre del proyecto" , example ="honduras")
	private String name;
	
	@ApiModelProperty(notes = "codigo del proyecto" , example ="PRY_HONDURAS")
	private String code;
	
	@ApiModelProperty(notes = "descripcion del proyecto" , example = "proyecto honduras")
	private String description ;
	
	@ApiModelProperty(notes = "fases del  proyecto")
	private List<Fase> fases; 	
	
}
