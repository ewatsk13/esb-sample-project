package com.esb.sample.project.types.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esb.sample.project.types.validator.constraints.AntiSqlInjectionString;

public class AntiSqlInjectionStringValidator implements ConstraintValidator<AntiSqlInjectionString, String>{

	private static final Logger LOGGER = LoggerFactory.getLogger(AntiSqlInjectionStringValidator.class);
	private static final String SQL_INJECTION_CHARACTERS_REGEX = "^((?!\\-\\-|\\<|\\>|\\;|\\=|\\:|\\'|\\/).)*$"; 
	
	private String name;
	
	public void initialize(AntiSqlInjectionString constraintAnnotation) {
		name = constraintAnnotation.name();
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		try {
			if(StringUtils.isNotBlank(value)) {
				if(!value.matches(SQL_INJECTION_CHARACTERS_REGEX)) {
					context.buildConstraintViolationWithTemplate(name + "must not contain '--', '<', '>', ';', '=', ''', '/' and ':'!")
						.addConstraintViolation();
					return false;
				}
			}
		}catch(Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
		
		return false;
	}

}
