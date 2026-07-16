package br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.User;

import static br.com.trajy.delivery.infra.identity.core.common.exception.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus.ACTIVE;

public final class UserFactory {

    private UserFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static User createUser(String email) {
        final User model = new User();
        model.setEmail(email);
        model.setStatus(ACTIVE);
        return model;
    }

}
