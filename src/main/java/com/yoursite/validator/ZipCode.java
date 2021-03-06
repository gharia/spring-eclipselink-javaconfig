package com.yoursite.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Custom Zip Code validator interface
 * @author Hemrajsinh Gharia
 *
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ZipCodeValidator.class)
@Documented
public @interface ZipCode {

	String message() default "{com.yoursite.checkzipcode}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
