package es.sergomz.validators;

import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;

public class UpperCaseValidator implements StringValidator {
    @Override
    public ValidationResult validate(String input) {
        return new ValidationResult(input.chars().anyMatch(Character::isUpperCase), getErrorMessage());
    }

    @Override
    public String getErrorMessage() {
        return "At least one uppercase character is required";

    }
}
