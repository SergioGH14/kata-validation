package es.sergomz.validators;

public class PasswordHelper {
    public static String generatePassword(int characters, int lowerCases, int upperCases, int digits, int underscores) {
        return UPPER_CASE.repeat(upperCases) +
                LOWER_CASE.repeat(lowerCases) +
                DIGIT.repeat(digits) +
                UNDERSCORE.repeat(underscores) +
                CHARACTER.repeat(characters - upperCases - lowerCases - digits - underscores);
    }

    static String UPPER_CASE = "A";
    static String LOWER_CASE = "a";
    static String DIGIT = "1";
    static String UNDERSCORE = "_";
    static String CHARACTER = "~";
}
