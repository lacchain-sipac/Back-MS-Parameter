package com.invest.honduras.domain.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GroupElement {
	private String type;
	private List<String> parameter;
}
