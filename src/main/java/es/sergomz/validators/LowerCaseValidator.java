package es.sergomz.validators;

import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;

public class LowerCaseValidator implements StringValidator {
    @Override
    public ValidationResult validate(String input) {
        return new ValidationResult(input.chars().anyMatch(Character::isLowerCase), getErrorMessage());
    }

    @Override
    public String getErrorMessage() {
        return "At least one lowercase character is required";

    }
}
