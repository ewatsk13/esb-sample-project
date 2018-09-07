package com.esb.sample.project.controller;

import java.util.List;
import java.util.Map;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esb.sample.project.domain.SampleTable;
import com.esb.sample.project.util.validationUtil;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("sample")
public class SampleProjectController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleProjectController.class);
	
	private static final String REQUEST_REFERENCE_NUMBER = "Request-Reference-No";
	
	@RequestMapping("/")
	public HttpEntity<String> sample(){
		System.out.println("Hello World");
		LOGGER.info("Sample Controller!!!");
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@RequestMapping(value="/sample", method = RequestMethod.GET)
	public HttpEntity<List<SampleTable>> get(@RequestHeader Map<String,String> headers){
		String referenceNumber = headers.get(REQUEST_REFERENCE_NUMBER);
		validateAndLogReference(referenceNumber);
		LOGGER.info("Getting Started..");
		return null;
	}

	public static void validateAndLogReference(String referenceNumber) {
		MDC.put("requestReferenceNumber", referenceNumber);
		validationUtil.UUIDValidator(referenceNumber, "'Request Reference No' header must a valid UUID!");
	}
}
