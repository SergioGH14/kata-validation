package es.sergomz.validators;

import es.sergomz.StringValidator;

public class UnderScoreValidator implements StringValidator {
    @Override
    public boolean validate(String input) {
        return input.chars().anyMatch(c -> ((char) c) == '_');
    }
}
