package org.example.password;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements org.example.password.PasswordGenerator {

    private static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";
    private static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

    public String generatePassword() {
        PasswordGenerator gen = new PasswordGenerator();

        EnglishCharacterData lowerCase = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCase);
        lowerCaseRule.setNumberOfCharacters(2);

        EnglishCharacterData upperCase = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCase);
        upperCaseRule.setNumberOfCharacters(2);

        EnglishCharacterData digit = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digit);
        digitRule.setNumberOfCharacters(2);

        CharacterData splChar = new CharacterData() {
            public String getErrorCode() {
                return ERROR_CODE;
            }

            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };
        CharacterRule splCharRule = new CharacterRule(splChar);
        splCharRule.setNumberOfCharacters(2);

        // 0 ~ 12
        return gen.generatePassword((int) (Math.random() * 13),
                splCharRule, lowerCaseRule, upperCaseRule, digitRule);
    }
}
