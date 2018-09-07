package com.esb.sample.project.controller;

import java.util.Map;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esb.sample.project.util.validationUtil;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("sample")
public class SampleProjectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleProjectController.class);
	
	private static final String REQUEST_REFERENCE_NO = "request-reference-no";
	
	@RequestMapping("/")
	public HttpEntity<String> sample(){
		System.out.println("Hello World");
		LOGGER.info("Sample Controller!!!");
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@RequestMapping(value="/{min}", method =  RequestMethod.GET)
	public HttpEntity<String> get(@RequestHeader Map<String, String> headers, @PathVariable("min") String min) {
		String referenceNumber = headers.get(REQUEST_REFERENCE_NO);
		validateAndLogReference(referenceNumber);
		LOGGER.info("Getting started for {}", referenceNumber);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	public static void validateAndLogReference(String referenceNumber) {
		MDC.put("requestReferenceNumber", referenceNumber);
		validationUtil.UUIDValidator(referenceNumber, "'Request Reference No' header must a valid UUID!");
	}
}
