package com.project.urlshortener.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.urlshortener.model.ApiResponse;
import com.project.urlshortener.model.UrlModel;
import com.project.urlshortener.service.UrlService;
import com.project.urlshortener.utilities.FieldValidator;

@RestController
public class UrlShortenerController {
	
	@Autowired
	UrlService urlService;
	
	@GetMapping("getOriginalUrl/{domain}/{url}")
	public ResponseEntity<?> getUrl(@PathVariable String url, @PathVariable String domain) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.OK);
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if(!FieldValidator.isValidString(url) && !FieldValidator.isValidString(domain)) {
				response = ApiResponse.badRequest(ApiResponse.INVALID_URL);
				
			} else {
				String originalUrl = urlService.getOriginalUrl(domain+"/"+url);
				
				if(originalUrl.equals("")) {
					response = ApiResponse.success(ApiResponse.URL_NOT_FOUND);
				} else {
					map.put("url", originalUrl);
					response = new ResponseEntity<>(map, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = ApiResponse.exception(e.getMessage());
		}
		
		return response;
	}

	@PostMapping("/getShortUrl")
	public ResponseEntity<?> createShortUrl(@RequestBody UrlModel model) {
		ResponseEntity<Object> response = new ResponseEntity<>(HttpStatus.OK);
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			if(!FieldValidator.isValidString(model.getUrl())) {
				response = ApiResponse.badRequest(ApiResponse.INVALID_URL);
				
			} else if(!FieldValidator.isValidString(model.getDomain())){
				response = ApiResponse.badRequest(ApiResponse.INVALID_DOMAIN);
				
			} else {
				String tinyUrl = urlService.getTinyUrl(model);
				map.put("tinyUrl", tinyUrl);
				response = new ResponseEntity<>(map, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = ApiResponse.exception(e.getMessage());
		}
		
		return response;
	}
}
