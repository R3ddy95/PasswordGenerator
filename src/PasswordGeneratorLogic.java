package src;

import java.security.SecureRandom;

public class PasswordGeneratorLogic {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static SecureRandom random = new SecureRandom();

    public static String generatePassword(int length, boolean includeUpperCase, boolean includeLowerCase,
                                          boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder(length);
        String allowedCharacters = "";

        if (includeUpperCase) {
            allowedCharacters += CHAR_UPPER;
        }
        if (includeLowerCase) {
            allowedCharacters += CHAR_LOWER;
        }
        if (includeDigits) {
            allowedCharacters += DIGIT;
        }
        if (includeSpecialChars) {
            allowedCharacters += SPECIAL_CHAR;
        }

        if (allowedCharacters.isEmpty()) {
            throw new IllegalArgumentException("You must select at least one font.");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            password.append(allowedCharacters.charAt(randomIndex));
        }
        return password.toString();
    }
}