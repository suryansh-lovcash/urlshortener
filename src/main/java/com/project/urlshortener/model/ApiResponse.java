package com.project.urlshortener.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

	// 200 series for success
	public static ResponseStatusModel SUCCESS
		= new ResponseStatusModel(200, "Success");
	
	// 400 series for custom errors
	public static ResponseStatusModel INVALID_DOMAIN
		= new ResponseStatusModel(406, "Domain name is required.");
	
	public static ResponseStatusModel INVALID_URL
		= new ResponseStatusModel(406, "Url is required.");

	// 1000 series for custom errors
	public static ResponseStatusModel URL_NOT_FOUND
		= new ResponseStatusModel(1001, "NO record found");
	
	public static ResponseEntity<Object> badRequest(ResponseStatusModel model) {
		return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<Object> exception(String message) {
		ResponseStatusModel model = new ResponseStatusModel(500, message);
		return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
	}

	public static ResponseEntity<Object> success(ResponseStatusModel model) {
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
}
