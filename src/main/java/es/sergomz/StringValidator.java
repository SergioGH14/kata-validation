package es.sergomz;

public interface StringValidator {
    ValidationResult validate(String input);

    String getErrorMessage();
}
