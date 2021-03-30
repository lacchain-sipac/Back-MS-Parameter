package com.invest.honduras.domain.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaseOption {

	
	@ApiModelProperty(notes = "nombre de la opcion de la fase" , example ="Crear Solicitud")
	private String name;
	
	@ApiModelProperty(notes = "codigo de la opcion de la  fase" , example ="fase_option_01_01")
	private String code;
	
	@ApiModelProperty(notes = "roles" , example ="ROLE_COO_TEC")
	private List<String> rolesAuth;
	
}
