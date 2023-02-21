package com.example.demo;

public class ApiResponse {
	private String message="Forca Barca! ";
	private int x=69;
	public ApiResponse(String message) {
		this.message+=message;
		this.message+=" Forca Barca!";
	}
	public String getMessage() {
		return message+" "+x;
	}
}
