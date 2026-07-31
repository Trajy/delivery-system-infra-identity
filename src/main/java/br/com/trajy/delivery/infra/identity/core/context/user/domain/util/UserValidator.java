package br.com.trajy.delivery.infra.identity.core.context.user.domain.util;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;

import java.util.ArrayList;
import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;

public final class UserValidator {

    private UserValidator() {
        utilityClassUnsupportedInstantiationException();
    }

    public static List<Error> validateUserUniqueFields(CreateUserWithPasswordCredentialWrapperInput input, UserAggregate user) {
        final List<Error> errors = new ArrayList<>();
        if(user == null && input.email().equals(user.getEmail())) {
                errors.add(Error.builder().description("User with email already exists").build());
        }
        return errors;
    }


}
