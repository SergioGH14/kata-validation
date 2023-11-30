import es.sergomz.PasswordValidationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationServiceTest {

    @Test
    @DisplayName("it returns true if the password is well formed")
    public void passwordWellFormed() {
        String password = generateCorrectPassword();
        boolean validation = passwordValidation.validate(password);
        assertTrue(validation);
    }


    @Test
    @DisplayName("it returns false if the password has less than 8 characters")
    public void lessThanEightCharacters() {
        String password = generatePassword(7, 1, 1, 1, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 upper case")
    public void moreThanOneUpperCase() {
        String password = generatePassword(8, 1, 0, 1, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 lower case")
    public void moreThanOneLowerCase() {
        String password = generatePassword(8, 0, 1, 1, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 digit")
    public void moreThanOneDigit() {
        String password = generatePassword(8, 0, 1, 0, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    @Test
    @DisplayName("it returns false if the password has less than 1 underscore")
    public void moreThanOneUnderScore() {
        String password = generatePassword(8, 0, 1, 0, 0);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }


    private String generateCorrectPassword() {
        return generatePassword(8, 1, 1, 1, 1);
    }

    private String generatePassword(int characters, int lowerCases, int upperCases, int digits, int underscores) {
        return UPPER_CASE.repeat(upperCases) +
                LOWER_CASE.repeat(lowerCases) +
                DIGIT.repeat(digits) +
                UNDERSCORE.repeat(underscores) +
                CHARACTER.repeat(characters - upperCases - lowerCases - digits - underscores);
    }

    private final PasswordValidationService passwordValidation = new PasswordValidationService();

    private static String UPPER_CASE = "A";
    private static String LOWER_CASE = "a";
    private static String DIGIT = "1";
    private static String UNDERSCORE = "_";
    private static String CHARACTER = "~";

}