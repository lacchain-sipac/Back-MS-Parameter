package com.invest.honduras.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invest.honduras.enums.TypeStatusCode;
import com.invest.honduras.http.ProyectAuthorizationResponse;
import com.invest.honduras.http.ProyectFaseOptionRequest;
import com.invest.honduras.http.ProyectGenericResponse;
import com.invest.honduras.http.ProyectRuleResponse;
import com.invest.honduras.http.ProyectTypeDocumentRequest;
import com.invest.honduras.http.ProyectTypeOperationRequest;
import com.invest.honduras.service.ProyectService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/api/v1/rules")
//@CrossOrigin(origins = "*")
@Slf4j
public class RulesController implements ApiRulesController {
	
	@Autowired
	ProyectService proyectService;
	
	@GetMapping(value = "/{proyect}", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE })	
	@Override
	public Mono<ResponseEntity<ProyectGenericResponse>> findbyName(@PathVariable("proyect") String proyectName) {
		// TODO Auto-generated method stub		
		return proyectService.findbyName(proyectName).flatMap(proyect -> {
			
			return Mono.just(ResponseEntity.ok(new ProyectGenericResponse(TypeStatusCode.OK.getCode(), proyect, TypeStatusCode.OK.getMessage())));
			
		}).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping(value = "/option", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@Override
	public Mono<ResponseEntity<ProyectAuthorizationResponse>> autorizationOption(@Valid ProyectFaseOptionRequest proyectRequest) {
		// TODO Auto-generated method stub
		log.info("option");
		return proyectService.autorizationOption(proyectRequest).flatMap(data -> {
			ProyectRuleResponse proyectRuleResponse = new ProyectRuleResponse();
			proyectRuleResponse.setAuth(data);
			return Mono.just(ResponseEntity.ok(
					new ProyectAuthorizationResponse(TypeStatusCode.OK.getCode(), proyectRuleResponse, TypeStatusCode.OK.getMessage())));	
			
		});
	}

	
	@PostMapping(value = "/type-operation", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@Override
	public Mono<ResponseEntity<ProyectAuthorizationResponse>> autorizationTypeOperation( @Valid  ProyectTypeOperationRequest proyectRequest) {
		// TODO Auto-generated method stub
		log.info("type-operation");
		
		
		return proyectService.autorizationTypeOperation(proyectRequest).flatMap(data -> {
			ProyectRuleResponse proyectRuleResponse = new ProyectRuleResponse();
			proyectRuleResponse.setAuth(data);
			return Mono.just(ResponseEntity.ok(
					new ProyectAuthorizationResponse(TypeStatusCode.OK.getCode(), proyectRuleResponse, TypeStatusCode.OK.getMessage())));	
			
		});
	}
	
	@PostMapping(value = "/type-document", produces = { MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@Override
	public Mono<ResponseEntity<ProyectAuthorizationResponse>> autorizationTypeDocument( @Valid ProyectTypeDocumentRequest proyectRequest) {
		// TODO Auto-generated method stub		
		return proyectService.autorizationTypeDocument(proyectRequest).flatMap(data -> {
			ProyectRuleResponse proyectRuleResponse = new ProyectRuleResponse();
			proyectRuleResponse.setAuth(data);
			return Mono.just(ResponseEntity.ok(
					new ProyectAuthorizationResponse(TypeStatusCode.OK.getCode(), proyectRuleResponse, TypeStatusCode.OK.getMessage())));	
			
		});
	}


	
}
