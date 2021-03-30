package com.invest.honduras.http;


import java.util.List;

public class ParameterGenericResponse extends HttpResponse<List<ParameterResponse>>{

	public ParameterGenericResponse(String status, List<ParameterResponse> data, String message) {
		super(status, data,message);
	}

}
