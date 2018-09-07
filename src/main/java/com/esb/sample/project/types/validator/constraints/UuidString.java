package com.esb.sample.project.types.validator.constraints;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.esb.sample.project.types.validator.UUIDStringValidator;

@Documented
@Constraint(validatedBy = UUIDStringValidator.class)
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface UuidString {

	String message() default "{com.esb.sample.project.types.validator.constraints.UuidString.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload> [] payload() default {};
}
