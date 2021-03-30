package com.invest.honduras.http;


import java.util.List;

import com.invest.honduras.domain.model.StateSolicitude;

public class StateSolicitudeResponse extends HttpResponse<List<StateSolicitude>>{

	public StateSolicitudeResponse(String status, List<StateSolicitude> data, String message) {
		super(status, data,message);
	}

}
