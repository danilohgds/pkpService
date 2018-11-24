package com.hackyeah.pkpService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

	@GetMapping("/health")
	@ResponseBody
	public String getHealth(){
		return "Backend is up and Running";
		
	}
	
	@RequestMapping("/hello")
	String hello() {
	  	    return "hello";
	}
}
