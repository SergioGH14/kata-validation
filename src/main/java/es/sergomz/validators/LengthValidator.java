package es.sergomz.validators;

import es.sergomz.StringValidator;

public class LengthValidator implements StringValidator {
    private final int length;
    public LengthValidator(int length){
        this.length = length;
    }

    @Override
    public boolean validate(String input) {
        return input.length() >= length;
    }
}
