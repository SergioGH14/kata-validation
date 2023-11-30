package es.sergomz.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static es.sergomz.validators.PasswordHelper.generatePassword;
import static org.junit.jupiter.api.Assertions.*;

class DigitValidatorTest {
    @Test
    @DisplayName("it returns true if the password is well formed")
    public void passwordWellFormed() {
        String password = generatePassword(8, 0, 0, 1, 0);
        var validation = passwordValidation.validate(password);
        assertTrue(validation.result);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 digit")
    public void moreThanOneDigit() {
        String password = generatePassword(8, 0, 0, 0, 0);
        var validation = passwordValidation.validate(password);
        assertFalse(validation.result);
    }

    private final DigitValidator passwordValidation = new DigitValidator();


}