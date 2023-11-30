import es.sergomz.PasswordValidationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationServiceTest {
    private final PasswordValidationService passwordValidation = new PasswordValidationService();

    @Test
    @DisplayName("it returns false if the password has less than 8 characters")
    public void lessThanEightCharacters() {
        String password = generatePassword(7, 1);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    @Test
    @DisplayName("it returns true if the password has more than 8 characters")
    public void moreThanEightCharacters() {
        String password = generateCorrectPassword();
        boolean validation = passwordValidation.validate(password);
        assertTrue(validation);
    }


    @Test
    @DisplayName("it returns false if the password has less than 1 upper case")
    public void moreThanOneUpperCase() {
        String password = generatePassword(8, 0);
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }


    private String generateCorrectPassword() {
        return generatePassword(8, 1);
    }

    private String generatePassword(int characters, int upperCase) {
        return UPPER_CASE.repeat(upperCase) +
                CHARACTER.repeat(characters - upperCase);
    }

    private static String UPPER_CASE = "A";
    private static String LOWER_CASE = "a";
    private static String CHARACTER = "~";

}