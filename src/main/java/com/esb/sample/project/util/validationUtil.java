package com.esb.sample.project.util;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import com.esb.sample.project.constants.ApplicationConstants;
import com.esb.sample.project.types.UUIDField;

public final class validationUtil {
	
	private static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
	private static final Validator VALIDATOR = VALIDATOR_FACTORY.getValidator();
	private static final Pattern PATTERN = Pattern.compile(ApplicationConstants.VALID_MSISDN);
	
	public static boolean msisdnValidator(String msisdn) {
		Matcher matcher = PATTERN.matcher(msisdn);
		return matcher.matches();
	}
	
	public static void UUIDValidator(String id, String message) throws IllegalArgumentException {
		String exceptionMessage = StringUtils.isNotEmpty(message) ? message : "Invalid UUID!";
		Set<ConstraintViolation<UUIDField>> constraintViolations = VALIDATOR.validate(new UUIDField(id));
		if(!constraintViolations.isEmpty()) {
			throw new IllegalArgumentException(exceptionMessage);
		}
	}
	
}
