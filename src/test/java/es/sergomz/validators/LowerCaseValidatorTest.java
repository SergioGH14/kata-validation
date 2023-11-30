package es.sergomz.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static es.sergomz.validators.PasswordHelper.generatePassword;
import static org.junit.jupiter.api.Assertions.*;

class LowerCaseValidatorTest {
    @Test
    @DisplayName("it returns true if the password is well formed")
    public void passwordWellFormed() {
        String password = generatePassword(8, 1, 0, 0, 0);
        var validation = passwordValidation.validate(password);
        assertTrue(validation.result);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 upper case")
    public void moreThanOneLowerCase() {
        String password = generatePassword(8, 0, 0, 0, 0);
        var validation = passwordValidation.validate(password);
        assertFalse(validation.result);
    }

    private final LowerCaseValidator passwordValidation = new LowerCaseValidator();

}