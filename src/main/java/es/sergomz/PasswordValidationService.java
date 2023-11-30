package es.sergomz;

import java.util.List;

public class PasswordValidationService {
    private final List<StringValidator> validations;

    public PasswordValidationService(List<StringValidator> validations) {
        this.validations = validations;
    }

    public ValidationResult validate(String password) {
        var errorMessages = validations.stream()
                .filter((StringValidator validator) -> !validator.validate(password).result)
                .map(StringValidator::getErrorMessage).toList();
        if (errorMessages.isEmpty()) {
            return new ValidationResult(true, "Everything is correct");
        } else {
            return new ValidationResult(false, errorMessages.toString());
        }
    }
}
