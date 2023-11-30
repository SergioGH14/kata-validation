package es.sergomz;

import es.sergomz.validators.*;

import java.util.List;

public class PasswordValidationBuilder {

    private final List<StringValidator> firstValidations = List.of(
            new LengthValidator(8),
            new LowerCaseValidator(),
            new UpperCaseValidator(),
            new DigitValidator(),
            new UnderScoreValidator());

    private final List<StringValidator> secondValidations = List.of(
            new LengthValidator(6),
            new LowerCaseValidator(),
            new UpperCaseValidator(),
            new DigitValidator());

    private final List<StringValidator> thirdValidations = List.of(
            new LengthValidator(16),
            new LowerCaseValidator(),
            new UpperCaseValidator(),
            new UnderScoreValidator());

    PasswordValidationService firstValidationService(){
        return new PasswordValidationService(firstValidations);
    }

    PasswordValidationService secondValidationService(){
        return new PasswordValidationService(secondValidations);
    }

    PasswordValidationService thirdValidationService(){
        return new PasswordValidationService(thirdValidations);
    }

}
