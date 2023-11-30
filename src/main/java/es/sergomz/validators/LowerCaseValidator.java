package es.sergomz.validators;

import es.sergomz.StringValidator;

public class LowerCaseValidator implements StringValidator {
    @Override
    public boolean validate(String input) {
        return input.chars().anyMatch(Character::isLowerCase);
    }
}
