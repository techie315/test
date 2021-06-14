package com.micro.service.second.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroService2Controller {

	private static final Logger log = LoggerFactory.getLogger(MicroService2Controller.class);
	
	/*
	 * Return String "Hello" wrapped with a spring response entity 
	 */
	@GetMapping(path = "/api/message")
	public ResponseEntity<String> getMessage() {
		log.info("calling micro service-2 getMessage method.");
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}
}
