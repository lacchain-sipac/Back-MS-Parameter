package com.invest.honduras.domain.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterElement {	
	private String description;
	private String code;
	private GroupElement  group; 
}
