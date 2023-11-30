import es.sergomz.PasswordValidationService;
import es.sergomz.StringValidator;
import es.sergomz.ValidationResult;
import es.sergomz.validators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static es.sergomz.validators.PasswordHelper.generatePassword;
import static org.junit.jupiter.api.Assertions.*;
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
    @DisplayName("it executes all the validations and if some are incorrect returns result fals and the reason")
    public void passwordIncorrect() {
        String password = generateIncorrectPassword();
        ValidationResult validation = passwordValidation.validate(password);
        validations.forEach((StringValidator validator) -> verify(validator).validate(password));
        assertFalse(validation.result);
        assertEquals(List.of(new UnderScoreValidator().getErrorMessage()).toString(), validation.message);
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