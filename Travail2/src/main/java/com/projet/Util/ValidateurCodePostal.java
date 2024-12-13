package com.projet.Util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidateurCodePostal implements ConstraintValidator<CodePostal, String> {
	private static String pattern = "[A-Z]\\d[A-Z](?: |-|)?\\d[A-Z]\\d";
	@Override
	public void initialize(CodePostal constraintAnnotation) {
	}
	@Override
	public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
		if ( object == null )
			return false;
		return Pattern.matches(pattern, object);
	}
}