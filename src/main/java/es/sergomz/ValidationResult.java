package es.sergomz;

public class ValidationResult {

    public boolean result;
    public String message;

    public ValidationResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
}
