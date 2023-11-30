import es.sergomz.PasswordValidationService;
import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;
import es.sergomz.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static es.sergomz.validators.PasswordHelper.generatePassword;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

class PasswordValidationServiceTest {

    @Test
    @DisplayName("it executes all the validations and return true if all are correct")
    public void passwordWellFormed() {
        String password = generateCorrectPassword();
        ValidationResult validation = passwordValidation.validate(password);
        validations.forEach((StringValidator validator) -> verify(validator).validate(password));
        assertTrue(validation.result);
    }

    @Test
    @DisplayName("it executes all the validations and return false if there is one or more incorrect")
    public void passwordIncorrect() {
        String password = generateIncorrectPassword();
        ValidationResult validation = passwordValidation.validate(password);
        validations.forEach((StringValidator validator) -> verify(validator).validate(password));
        assertFalse(validation.result);
    }

    private final List<StringValidator> validations = List.of(
            Mockito.spy(new LengthValidator(16)),
            Mockito.spy(new LowerCaseValidator()),
            Mockito.spy(new UpperCaseValidator()),
            Mockito.spy(new UnderScoreValidator()));

    private final PasswordValidationService passwordValidation = new PasswordValidationService(validations);

    private String generateCorrectPassword() {
        return generatePassword(16, 1, 1, 0, 1);
    }

    private String generateIncorrectPassword() {
        return generatePassword(16, 1, 1, 0, 0);
    }

}