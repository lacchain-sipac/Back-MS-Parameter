
package com.invest.honduras.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Privilege {

	@ApiModelProperty(notes = "descripcion del privilegio" ,example ="Privilegio Ejemplo")
	private String description;
	
	@ApiModelProperty(notes = "codigo del privilegio" ,example ="01")
	private String code;
}
