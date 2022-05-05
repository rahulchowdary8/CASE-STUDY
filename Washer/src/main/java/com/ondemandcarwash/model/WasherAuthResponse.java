package com.ondemandcarwash.model;

public class WasherAuthResponse {

	private String Response;

	public WasherAuthResponse(String response) {
		super();
		Response = response;
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	@Override
	public String toString() {
		return "WasherAuthResponse [Response=" + Response + "]";
	}

	
}
