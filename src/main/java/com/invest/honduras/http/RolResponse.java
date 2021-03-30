package com.invest.honduras.http;

import java.util.List;

import com.invest.honduras.domain.model.Role;


public class RolResponse extends HttpResponse<List<Role>>{

	public RolResponse(String status, List<Role> data , String message) {
		super(status, data, message);
	}

}
