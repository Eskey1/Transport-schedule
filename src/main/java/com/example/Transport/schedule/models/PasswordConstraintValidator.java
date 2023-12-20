package com.example.Transport.schedule.models;


import com.example.Transport.schedule.repository.ValidPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
//
//    @Override
//    public void initialize(ValidPassword constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(String password, ConstraintValidatorContext context) {
//        PasswordValidator validator = new PasswordValidator(Arrays.asList(
//                // at least 8 characters
//                new LengthRule(8, 100),
//
//                // at least one upper-case character
//                new CharacterRule(EnglishCharacterData.UpperCase, 1),
//
//                // at least one lower-case character
//                new CharacterRule(EnglishCharacterData.LowerCase, 1),
//
//                // at least one digit character
//                new CharacterRule(EnglishCharacterData.Digit, 1),
//
//                // at least one symbol (special character)
//                new CharacterRule(EnglishCharacterData.Special, 1),
//
//                // no whitespace
//                new WhitespaceRule()
//
//        ));
//        RuleResult result = validator.validate(new PasswordData(password));
//        if (result.isValid()) {
//            return true;
//        }
//        List<String> messages = validator.getMessages(result);
//        String messageTemplate = messages.stream()
//                .collect(Collectors.joining(","));
//        context.buildConstraintViolationWithTemplate("Password does not meet complexity requirements")
//                .addConstraintViolation()
//                .disableDefaultConstraintViolation();
//        return false;
//    }
//}
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        // Проверка условий сложности пароля
        boolean hasMinLength = password.length() >= 8;
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSymbol = password.matches(".*[^a-zA-Z0-9].*");

        boolean isPasswordValid = hasMinLength && hasUppercase && hasLowercase && hasDigit && hasSymbol;

        if (!isPasswordValid && context != null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Password does not meet complexity requirements")
                    .addConstraintViolation();
        }

        return isPasswordValid;
    }
}
