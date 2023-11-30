package es.sergomz.validators;

import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;

public class DigitValidator implements StringValidator {
    @Override
    public ValidationResult validate(String input) {
        return new ValidationResult(input.chars().anyMatch(Character::isDigit), getErrorMessage());
    }

    @Override
    public String getErrorMessage() {
        return "At least one digit is required";
    }
}
