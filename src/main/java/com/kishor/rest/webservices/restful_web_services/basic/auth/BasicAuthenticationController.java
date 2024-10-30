package com.kishor.rest.webservices.restful_web_services.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {
	
	@GetMapping(path = "/basicauth")
	public AuthenticatinBean getAuthentication()
	{
		return new AuthenticatinBean("Basic Authentication Bean return");
	}

}
