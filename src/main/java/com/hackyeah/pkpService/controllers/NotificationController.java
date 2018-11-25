package com.hackyeah.pkpService.controllers;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotificationController {
	
	HashMap<String,String> messages = new HashMap<>();

	@GetMapping("/getMessages")
	@ResponseBody
	public ResponseEntity<String> getMessages(@RequestParam(required=true) String userId) {
		String message = messages.getOrDefault(userId, "You have no Messages");
		messages.remove(userId);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@PutMapping("/sendMessage")
	@ResponseBody
	public ResponseEntity<String> sendMessage(@RequestParam(required=true) String userId, @RequestParam(required=true) String message ) {
		if(!messages.containsKey(userId)) {
			messages.put(userId, message);
			return ResponseEntity.status(HttpStatus.OK).body("Message sent succesfully");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User has too many messages");	
		
	}
	
}
