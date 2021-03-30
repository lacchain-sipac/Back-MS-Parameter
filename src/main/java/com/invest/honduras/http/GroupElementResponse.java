package com.invest.honduras.http;

import java.util.List;

import com.invest.honduras.domain.model.ParameterBase;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GroupElementResponse {
	
	@ApiModelProperty(notes = "tipo parametro asociado" , example ="AssociatedComponent")
	private String type;
	
	@ApiModelProperty(notes = "lista de parametro asociados")
	private List<ParameterBase> parameter;
}
