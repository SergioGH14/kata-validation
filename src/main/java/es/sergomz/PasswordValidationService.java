package es.sergomz;

import java.util.List;

public class PasswordValidationService {
    private final List<StringValidator> validations;

    public PasswordValidationService(List<StringValidator> validations) {
        this.validations = validations;
    }

    public boolean validate(String password) {
        return validations.stream().allMatch((StringValidator validator) -> validator.validate(password));
    }
}
