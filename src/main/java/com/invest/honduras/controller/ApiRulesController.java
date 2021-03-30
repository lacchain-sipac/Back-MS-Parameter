package com.invest.honduras.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.invest.honduras.http.ProyectAuthorizationResponse;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectGenericResponse;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;
import com.invest.honduras.http.RolResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

public interface ApiRulesController {

	
	@ApiOperation(
            value = "Interfaz API para obtener la informacion de un determinado proyecto en la aplicacion SIPAC.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
            response = ProyectGenericResponse.class,
            httpMethod = "GET" 
            )    	
    @ApiResponses(value = {    		
      		 @ApiResponse(code = 200, message = "Exito al obtener la informacon de un determinado proyecto" , response = ProyectGenericResponse.class),
               @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
               @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
               @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
      }
      		)	
	
	public Mono<ResponseEntity<ProyectGenericResponse>> findbyName(@ApiParam(example = "honduras") String proyectName);
	
	
	@ApiOperation(
            value = "Interfaz API para determinar  si un determinado rol tiene permiso sobre una opcion en la aplicacion SIPAC",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
            response = ProyectAuthorizationResponse.class,
            httpMethod = "POST" 
            )
	
    @ApiResponses(value = {    		
     		 @ApiResponse(code = 200, message = "Exito" , response = ProyectAuthorizationResponse.class),
              @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
              @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
              @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
     }
     		)
	
    Mono<ResponseEntity<ProyectAuthorizationResponse>>autorizationOption(@RequestBody ProyectFaseOptionRequest proyectRequest);

	
	
    @ApiOperation(
            value = "Interfaz API para determinar si un determinado rol tiene permiso sobre un tipo de operacion en la aplicacion SIPAC",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = 	ProyectAuthorizationResponse.class,
            httpMethod = "POST" 
            )    
    
    @ApiResponses(value = {    		
    		 @ApiResponse(code = 200, message = "Exito" , response = ProyectAuthorizationResponse.class),
             @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
             @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
             @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
    }
    		)
	    
    
    Mono<ResponseEntity<ProyectAuthorizationResponse>> autorizationTypeOperation(@RequestBody ProyectTypeOperationRequest proyectRequest);
    
    
    @ApiOperation(
            value = "Interfaz API para determinar si un determinado rol tiene permiso sobre un tipo de documento en la aplicacion SIPAC",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = 	ProyectAuthorizationResponse.class,
            httpMethod = "POST" 
            )
    @ApiResponses(value = {    		
   		 @ApiResponse(code = 200, message = "Exito" , response = ProyectAuthorizationResponse.class),
            @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
            @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
            @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
   }
   		)

    Mono<ResponseEntity<ProyectAuthorizationResponse>> autorizationTypeDocument(@RequestBody ProyectTypeDocumentRequest proyectRequest);
    
    
}
