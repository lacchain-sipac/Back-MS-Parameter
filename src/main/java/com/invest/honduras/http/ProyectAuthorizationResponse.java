package com.invest.honduras.http;

public class ProyectAuthorizationResponse extends HttpResponse<ProyectRuleResponse>{

	public ProyectAuthorizationResponse(String status,ProyectRuleResponse data, String message) {
		super(status, data,message);
	}

}
