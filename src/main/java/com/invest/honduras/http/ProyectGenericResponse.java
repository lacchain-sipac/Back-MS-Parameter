package com.invest.honduras.http;


import com.invest.honduras.domain.model.Rule;


public class ProyectGenericResponse extends HttpResponse<Rule>{

	public ProyectGenericResponse(String status,Rule data, String message) {
		super(status, data,message);
	}

}
