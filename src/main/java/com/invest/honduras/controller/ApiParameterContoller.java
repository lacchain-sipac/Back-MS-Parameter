package com.invest.honduras.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.invest.honduras.http.ParameterGenericResponse;
import com.invest.honduras.http.RolResponse;
import com.invest.honduras.http.StateSolicitudeResponse;
import com.invest.honduras.http.StateUserResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

public interface ApiParameterContoller {

	@ApiOperation(
            value = "Interfaz API para listar todos los roles en la aplicacion SIPAC.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
            response = RolResponse.class,
            httpMethod = "GET" 
            )
    @ApiResponses(value = {    		
   		 @ApiResponse(code = 200, message = "Exito al obtener la lista de roles" , response = RolResponse.class),
            @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
            @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
            @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
   }
   		)	
    Mono<ResponseEntity<RolResponse>> listRoles();

    @ApiOperation(
            value = "Interfaz API para listar todos los estados de un usuario en la aplicacion SIPAC.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = 	StateUserResponse.class,
            httpMethod = "GET" 
            )
    @ApiResponses(value = {    		
      		 @ApiResponse(code = 200, message = "Exito al obtener la lista de estados de un usuario" , response = StateUserResponse.class),
               @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
               @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
               @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
      }
      		)
    Mono<ResponseEntity<StateUserResponse>> listStatesUser();
    
    
    @ApiOperation(
            value = "Interfaz API para listar todos los estados de un proceso en la aplicacion SIPAC.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = 	StateSolicitudeResponse.class,
            httpMethod = "GET" 
            )

    @ApiResponses(value = {    		
     		 @ApiResponse(code = 200, message = "Exito al obtener la lista de estados de la solicitud" , response = StateSolicitudeResponse.class),
              @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
              @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
              @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
     }
     		)
    Mono<ResponseEntity<StateSolicitudeResponse>> listStatusSolicitude();

    
    @ApiOperation(
            value = "Interfaz API para listar los datos de un parametro en la aplicacion SIPAC.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = 	ParameterGenericResponse.class,
            httpMethod = "GET" 
            )   
    @ApiResponses(value = {    		
    		 @ApiResponse(code = 200, message = "Exito al obtener la lista de datos de un determinado parametro", response = ParameterGenericResponse.class),
             @ApiResponse(code = 401, message = "No autorizado para obtener el recurso"),
             @ApiResponse(code = 403, message = "El acceso al recurso esta prohibido"),
             @ApiResponse(code = 404, message = " El recurso no pudo ser encontrado")
    }
    		)   
    
    
    Mono<ResponseEntity<ParameterGenericResponse>> listParameter(@ApiParam(example = "OperationNumber") @PathVariable("parameter") String parameter) ;
    
	

}
