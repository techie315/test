package com.micro.service.third.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.third.dto.User;
import com.micro.service.third.exception.NoSuchElementFoundException;

@RestController
public class MicroService3Controller {
	
	private static final Logger log = LoggerFactory.getLogger(MicroService3Controller.class);
	
	@PostMapping(path = "/api/name")
	public ResponseEntity<String> getUserName(@RequestBody User user) {
		log.info("calling micro service-3 getUserName method.");
		if(StringUtils.isNotBlank(user.getName()) && StringUtils.isNotBlank(user.getSurname())) {
			log.info("Response from micro service-3 that is {}", user.toString());
			return ResponseEntity.ok().body(user.toString())	;
		}else {
			log.error("Field can not be blank");
			throw new NoSuchElementFoundException(HttpStatus.BAD_REQUEST, "Field can not be blank");
		}
	}
}
