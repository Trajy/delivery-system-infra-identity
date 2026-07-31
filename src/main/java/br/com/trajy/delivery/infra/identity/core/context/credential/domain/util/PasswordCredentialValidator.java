package br.com.trajy.delivery.infra.identity.core.context.credential.domain.util;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.common.exception.type.InconsistentStateException;
import br.com.trajy.delivery.infra.identity.core.context.credential.domain.model.aggregate.PasswordCredentialAggregate;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import java.util.ArrayList;
import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.InconsistentStateException.InconsistentStateExceptionBuilder;
import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class PasswordCredentialValidator {

    private static final int MIN_LENGTH = 8;

    private PasswordCredentialValidator() {
         utilityClassUnsupportedInstantiationException();
    }

    public static <T> void validatePasswordCredentialConsistency(Class<T> originClazz, PasswordCredentialAggregate encryptedPasswordCredentialAggregate ,PasswordCredentialAggregate passwordCredentialAggregate) {
        final InconsistentStateExceptionBuilder inconsistentStateExceptionBuilder = InconsistentStateException.builder();
        if(nonNull(passwordCredentialAggregate)) {
            if(isNull(passwordCredentialAggregate.getUser())) {
                inconsistentStateExceptionBuilder.appendMessage(format("%s with id: %s is not associated with any %s.", PasswordCredentialAggregate.class.getSimpleName(), passwordCredentialAggregate.getId(), UserAggregate.class.getSimpleName()));
            }
            if(isNull(passwordCredentialAggregate.getHashAlgorithmType())) {
                inconsistentStateExceptionBuilder.appendMessage(format("%s with id: %s without encryption algorithm type", PasswordCredentialAggregate.class.getSimpleName(), passwordCredentialAggregate.getId()));
            }
        }
        inconsistentStateExceptionBuilder.throwIfHasMessage();
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
