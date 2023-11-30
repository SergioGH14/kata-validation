package es.sergomz;

import java.util.List;

public class PasswordValidationService {
    private final List<StringValidator> validations;

    public PasswordValidationService(List<StringValidator> validations) {
        this.validations = validations;
    }

    public ValidationResult validate(String password) {
        return new ValidationResult(validations.stream().allMatch((StringValidator validator) -> validator.validate(password)));
    }
}
