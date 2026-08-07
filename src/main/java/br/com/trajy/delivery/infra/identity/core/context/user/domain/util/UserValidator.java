package br.com.trajy.delivery.infra.identity.core.context.user.domain.util;

import br.com.trajy.delivery.infra.identity.core.common.exception.model.Error;
import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateWithPasswordCredentialWrapperInput;

import java.util.ArrayList;
import java.util.List;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static java.util.Objects.nonNull;

public final class UserValidator {

    private UserValidator() {
        utilityClassUnsupportedInstantiationException();
    }

    public static List<Error> validateUserUniqueFields(CreateWithPasswordCredentialWrapperInput input, UserAggregate userAggregate) {
        final List<Error> errors = new ArrayList<>();
        if(nonNull(userAggregate) && input.email().equals(userAggregate.getEmail())) {
                errors.add(Error.builder().description("User with email already exists").build());
        }
        return errors;
    }


}
