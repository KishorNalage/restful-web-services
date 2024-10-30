package com.kishor.rest.webservices.restful_web_services.basic.auth;

public class AuthenticatinBean {
	private String message;

	public AuthenticatinBean(String message) {
		this.message=message;
	}

	@Override
	public String toString() {
		return "AuthenticatinBean [message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
