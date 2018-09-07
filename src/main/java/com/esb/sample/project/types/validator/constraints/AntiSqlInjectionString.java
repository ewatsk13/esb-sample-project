package com.esb.sample.project.types.validator.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.esb.sample.project.types.validator.AntiSqlInjectionStringValidator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = AntiSqlInjectionStringValidator.class)
@Target({FIELD, METHOD, PARAMETER})
@Retention(RUNTIME)

public @interface AntiSqlInjectionString {
	
	String name();
	String message() default "{com.esb.sample.project.types.validator.constraints.AntiSqlInjectionString.message}";
	Class<?> [] groups() default {};
	Class<? extends Payload> [] payload() default {};

}
