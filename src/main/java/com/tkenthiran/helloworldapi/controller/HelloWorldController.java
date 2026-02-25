package com.tkenthiran.helloworldapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tkenthiran.helloworldapi.service.HelloWorldService;

@RestController
public class HelloWorldController {

	private final HelloWorldService helloWorldService;

	public HelloWorldController(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}

	@GetMapping("/hello-world")
	public ResponseEntity<Map<String, String>> helloWorld(@RequestParam(required = false) String name) {
		Map<String, String> response = new HashMap<>();

		if (helloWorldService.isValidName(name)) {
			String formattedName = helloWorldService.formatName(name);
			response.put("message", "Hello " + formattedName);
			return ResponseEntity.ok(response);
		} else {
			response.put("error", "Invalid Input");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
