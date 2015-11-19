package com.yoursite.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Override
	public void initialize(ZipCode arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String zip, ConstraintValidatorContext constraintContext) {
		// TODO Auto-generated method stub
		if (zip == null)
            return false;
		
		if(!zip.matches("\\d{6}")){
			return false;
		}
		
		return true;
	}

}
