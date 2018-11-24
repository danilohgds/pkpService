package com.hackyeah.pkpService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

	@GetMapping("/health")
	@ResponseBody
	public String getHealth() {
		return "Backend is up and Running";

	}
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	@ResponseBody
	public Boolean getLogin(@RequestBody(required=true) String password) {
		if(password.equalsIgnoreCase("epam2018")) {
			return true;
		}	
		System.out.println(password);	
		return false;

	}
}
