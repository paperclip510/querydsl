package com.shdh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/")
public class MainController {
	Environment env;

	@Autowired
	public MainController(Environment env) {
		this.env = env;
	}

	
	
	@GetMapping(value="/health_check")
	public String healthCheck() {
		return String.format("It's Working in "
				+ "\n\tport(local.server.port)="+env.getProperty("local.server.port")
				+ "\n\tport(server.port)="+env.getProperty("server.port")
				);
	}
	
}
