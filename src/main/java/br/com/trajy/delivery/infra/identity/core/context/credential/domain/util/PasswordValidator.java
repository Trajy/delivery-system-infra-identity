package br.com.trajy.delivery.infra.identity.core.context.credential.domain.util;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;

import java.util.ArrayList;
import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public final class PasswordValidator {

    private static final int MIN_LENGTH = 8;

    private PasswordValidator() {
         utilityClassUnsupportedInstantiationException();
    }

    public static List<Error> validatePassword(String password) {
        final List<Error> errors = new ArrayList<>();
        if (password == null || password.length() < MIN_LENGTH) {
            errors.add(Error.builder().description("Password must be at least " + MIN_LENGTH + " characters long.").build());
        }
        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        for (char character : password.toCharArray()) {
            if (isLetter(character)) {
                hasLetter = true;
            } else if (isDigit(character)) {
                hasNumber = true;
            } else {
                hasSpecialCharacter = true;
            }
        }
        if (!hasLetter || !hasNumber || !hasSpecialCharacter) {
            errors.add(Error.builder().description("Password must contain at least one letter, one number, and one special character.").build());
        }
        return errors;
    }

}
