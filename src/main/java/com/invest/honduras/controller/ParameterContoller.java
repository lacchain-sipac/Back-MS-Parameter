package com.invest.honduras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invest.honduras.enums.TypeStatusCode;
import com.invest.honduras.http.ParameterGenericResponse;
import com.invest.honduras.http.RolResponse;
import com.invest.honduras.http.StateSolicitudeResponse;
import com.invest.honduras.http.StateUserResponse;
import com.invest.honduras.service.ParameterService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/api/v1/parameter")
@Slf4j
public class ParameterContoller implements ApiParameterContoller {

	@Autowired
	ParameterService parameterService;

	@GetMapping(value = "/role", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Mono<ResponseEntity<RolResponse>> listRoles() {
		log.debug("listRoles");
		return parameterService.listRoles().collectList()
				.flatMap(roles -> Mono.just(ResponseEntity.ok(new RolResponse(TypeStatusCode.OK.getCode(), roles,TypeStatusCode.OK.getMessage()))))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	
	@GetMapping(value = "/state-user", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public Mono<ResponseEntity<StateUserResponse>> listStatesUser() {

		return parameterService.listStatesUser().collectList()
				.flatMap(states -> Mono.just(ResponseEntity.ok(new StateUserResponse(TypeStatusCode.OK.getCode(), states,TypeStatusCode.OK.getMessage()))))
				.defaultIfEmpty(ResponseEntity.notFound().build());

	}

	
	@GetMapping(value = "/state-solicitude", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@Override
	public Mono<ResponseEntity<StateSolicitudeResponse>> listStatusSolicitude() {
		// TODO Auto-generated method stub
		return parameterService.listStatesSolicitude().collectList()
				.flatMap(states -> Mono.just(ResponseEntity.ok(new StateSolicitudeResponse(TypeStatusCode.OK.getCode(), states,TypeStatusCode.OK.getMessage()))))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}


	@GetMapping(value = "/{type-parameter}", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@Override
	public Mono<ResponseEntity<ParameterGenericResponse>> listParameter( @PathVariable("type-parameter") String typeParameter) {
		// TODO Auto-generated method stub
		
		return parameterService.listParameterbyType(typeParameter)
				.map(parameter -> 
				{  				
				  return ResponseEntity.ok(
							new ParameterGenericResponse(
									TypeStatusCode.OK.getCode(),parameter,TypeStatusCode.OK.getMessage()));
								
					}
					
						)
				.defaultIfEmpty(ResponseEntity.notFound().build());
		
	}
	

}
