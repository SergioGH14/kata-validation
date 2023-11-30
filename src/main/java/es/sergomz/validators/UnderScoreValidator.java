package es.sergomz.validators;

import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;

public class UnderScoreValidator implements StringValidator {
    @Override
    public ValidationResult validate(String input) {
        return new ValidationResult(input.chars().anyMatch(c -> ((char) c) == '_'), getErrorMessage());
    }

    @Override
    public String getErrorMessage() {
        return "At least one underscore is required";
    }

}
