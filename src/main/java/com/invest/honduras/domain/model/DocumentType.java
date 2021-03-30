package com.invest.honduras.domain.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DocumentType {

	@ApiModelProperty(notes = "nombre del documento" , example ="Documento Especificación Tecnica")
	private String name ;
	
	@ApiModelProperty(notes = "codigo del documento" , example ="doc_01_04_01")
	private String code ;
	
	@ApiModelProperty(notes = "descripcion del documento" , example ="Documento Especificación Tecnica")
	private String description ;
	
	@ApiModelProperty(notes = "tipo de clasificacion del documento")
	private List<ClasificationType> clasificationType;
	
	@ApiModelProperty(notes = "tipo de accion" )
	private List<AccessType> actionType;
	
	@ApiModelProperty(notes = "documentos asociados")
	private List<DocumentType> documentTypeAssociated;
}
