package com.esb.sample.project.types.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esb.sample.project.types.validator.constraints.UuidString;

public class UUIDStringValidator implements ConstraintValidator<UuidString, String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(UUIDStringValidator.class);
	private static final String UUID_REGEX = "[0-9a-f]{8}(?:-[0-9a-f]{4}){3}-[0-9a-f]{12}";


	
	public void initialize(UuidString constraintAnnotation) {
		
	}

	
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		try {
			if(StringUtils.isNotBlank(value)) {
				if (!value.matches(UUID_REGEX)) {
					context.buildConstraintViolationWithTemplate("Must be in UUID pattern!")
							.addConstraintViolation();
					return false;
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return true;
	}

}
