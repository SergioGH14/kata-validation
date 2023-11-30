package es.sergomz.validators;

import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;

public class LengthValidator implements StringValidator {
    private final int length;
    public LengthValidator(int length){
        this.length = length;
    }

    @Override
    public ValidationResult validate(String input) {
        return new ValidationResult( input.length() >= length, getErrorMessage());
    }

    @Override
    public String getErrorMessage() {
        return "At least "+length+" characters are required";
    }
}
