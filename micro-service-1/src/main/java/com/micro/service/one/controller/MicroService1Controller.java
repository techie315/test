package com.micro.service.one.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.service.one.dto.User;
import com.micro.service.one.exception.ResponseErrorException;
import com.micro.service.one.exception.handler.RequestExceptionHandler;

@RestController
public class MicroService1Controller {
	
	private static final Logger log = LoggerFactory.getLogger(MicroService1Controller.class);
	
	private static final String SERVICE_2_URL="http://micro-service-2/api/message";
	private static final String SERVICE_3_URL="http://micro-service-3/api/name";
	
	@Autowired
    private RestTemplate restTemplate;

	/*
	 * If service is up, return Up
	 */
	@GetMapping(path = "/api/status")
	public String getServiceStatus() {
		log.info("calling micro service-1 getServiceStatus method.");
		return "Up";
	}
	
	/*
	 * Combined the response from microservice2 and microservice3
	 */
	@PostMapping(path = "/api/user")
	public ResponseEntity<String> getUserDetail(@RequestBody User user) {
		log.info("calling micro service-1 getUserDetail method.");
		
		//calling service 2nd
		String message = restTemplate.getForObject(SERVICE_2_URL,String.class);
		
		log.info("calling micro service-2 from micro service-1 to get message that is {}", message);
		
		//calling service 3rd
		URI microService3EndPointURL;
		try {
			microService3EndPointURL = new URI(SERVICE_3_URL);
			restTemplate.setErrorHandler(new RequestExceptionHandler());
			
			ResponseEntity<String> response = restTemplate.postForEntity(microService3EndPointURL, user, String.class);
			if (response.getStatusCode() == HttpStatus.OK) {
				return ResponseEntity.ok().body(message + " " + response.getBody());
			}else {
				log.error("Error response from service-3 that is {}", response.getBody());
				throw new ResponseErrorException(
					     "Error in response : " + response.getStatusCode() + " : " + response.getBody());
			}
		} catch (URISyntaxException e) {
			log.error("URISyntaxException error " , e.getMessage());
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("service-3 is down due to some technical issue, team is working on.");
		} 
	}
	
	
}
