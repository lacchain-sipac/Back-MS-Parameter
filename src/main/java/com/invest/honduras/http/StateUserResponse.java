package com.invest.honduras.http;


import java.util.List;

import com.invest.honduras.domain.model.StateUser;

public class StateUserResponse extends HttpResponse<List<StateUser>>{

	public StateUserResponse(String status, List<StateUser> data, String message) {
		super(status, data,message);
	}

}
