package com.example.demo;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MessageController {
	@GetMapping("/check")
	public String checkApi() throws JsonProcessingException{
		ApiResponse response=new ApiResponse("Glory Glory Real Madrid! Glory Glory Real Madrid! Hala Madrid!");
		ObjectMapper obj=new ObjectMapper();
		return obj.writeValueAsString(response);
	}
}
