package es.sergomz;

public class PasswordValidationService {

    public boolean validate(String password) {
        return password.length() >= 8 &&
                password.chars().anyMatch(Character::isUpperCase) &&
                password.chars().anyMatch(Character::isLowerCase) &&
                password.chars().anyMatch(Character::isDigit) &&
                password.chars().anyMatch(c -> ((char) c) == '_');
    }
}
