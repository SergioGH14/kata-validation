package es.sergomz.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthValidatorTest {
    @Test
    @DisplayName("it returns true if the password is well formed")
    public void passwordWellFormed() {
        String password = PasswordHelper.generatePassword(length, 1, 1, 1, 1);
        boolean validation = passwordValidation.validate(password);
        assertTrue(validation);
    }


    @Test
    @DisplayName("it returns false if the password has less than 8 characters")
    public void lessThanEightCharacters() {
        String password = PasswordHelper.generatePassword(length-1, 1, 1, 1, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    private final int length = 5;
    private final LengthValidator passwordValidation = new LengthValidator(length);

}