import es.sergomz.PasswordValidationService;
import es.sergomz.StringValidator;
import es.sergomz.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidationServiceTest {
    @Nested
    class FirstValidations {
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

        private final List<StringValidator> firstValidations = List.of(
                new LengthValidator(8),
                new LowerCaseValidator(),
                new UpperCaseValidator(),
                new DigitValidator(),
                new UnderScoreValidator());

        private final PasswordValidationService passwordValidation = new PasswordValidationService(firstValidations);
        private String generateCorrectPassword() {
            return generatePassword(8, 1, 1, 1, 1);
        }

    }

    @Nested
    class SecondValidations {
        @Test
        @DisplayName("it returns true if the password is well formed")
        public void passwordWellFormed() {
            String password = generateCorrectPassword();
            boolean validation = passwordValidation.validate(password);
            assertTrue(validation);
        }


        @Test
        @DisplayName("it returns false if the password has less than 6 characters")
        public void lessThanSixCharacters() {
            String password = generatePassword(5, 1, 1, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 upper case")
        public void moreThanOneUpperCase() {
            String password = generatePassword(6, 1, 0, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 lower case")
        public void moreThanOneLowerCase() {
            String password = generatePassword(6, 0, 1, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 digit")
        public void moreThanOneDigit() {
            String password = generatePassword(6, 0, 1, 0, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        private final List<StringValidator> secondValidations = List.of(
                new LengthValidator(6),
                new LowerCaseValidator(),
                new UpperCaseValidator(),
                new DigitValidator());

        private final PasswordValidationService passwordValidation = new PasswordValidationService(secondValidations);

        private String generateCorrectPassword() {
            return generatePassword(6, 1, 1, 1, 0);
        }

    }

    @Nested
    class ThirdValidations {
        @Test
        @DisplayName("it returns true if the password is well formed")
        public void passwordWellFormed() {
            String password = generateCorrectPassword();
            boolean validation = passwordValidation.validate(password);
            assertTrue(validation);
        }


        @Test
        @DisplayName("it returns false if the password has less than 16 characters")
        public void lessThanSixCharacters() {
            String password = generatePassword(15, 1, 1, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 upper case")
        public void moreThanOneUpperCase() {
            String password = generatePassword(16, 1, 0, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 lower case")
        public void moreThanOneLowerCase() {
            String password = generatePassword(16, 0, 1, 1, 1);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        @Test
        @DisplayName("it returns false if the password has less than 1 underscore")
        public void moreThanOneUnderScore() {
            String password = generatePassword(16, 0, 1, 0, 0);
            boolean validation = passwordValidation.validate(password);
            assertFalse(validation);
        }

        private final List<StringValidator> secondValidations = List.of(
                new LengthValidator(16),
                new LowerCaseValidator(),
                new UpperCaseValidator(),
                new UnderScoreValidator());

        private final PasswordValidationService passwordValidation = new PasswordValidationService(secondValidations);

        private String generateCorrectPassword() {
            return generatePassword(16, 1, 1, 0, 1);
        }

    }


    private String generatePassword(int characters, int lowerCases, int upperCases, int digits, int underscores) {
        return UPPER_CASE.repeat(upperCases) +
                LOWER_CASE.repeat(lowerCases) +
                DIGIT.repeat(digits) +
                UNDERSCORE.repeat(underscores) +
                CHARACTER.repeat(characters - upperCases - lowerCases - digits - underscores);
    }

    private static String UPPER_CASE = "A";
    private static String LOWER_CASE = "a";
    private static String DIGIT = "1";
    private static String UNDERSCORE = "_";
    private static String CHARACTER = "~";

}