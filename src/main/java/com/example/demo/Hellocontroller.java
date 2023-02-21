package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
	@GetMapping("/hello")
	public String Greet() {
		return "Hello World!";
	}
}
