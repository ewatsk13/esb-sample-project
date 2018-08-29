package com.esb.sample.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class SampleProjectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleProjectController.class);
	
	@RequestMapping("/")
	public HttpEntity<String> sample(){
		System.out.println("Hello World");
		LOGGER.info("Sample Controller!!!");
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}

}
