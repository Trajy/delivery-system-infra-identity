package br.com.trajy.delivery.infra.identity.core.context.user.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.user.domain.model.aggregate.UserAggregate;

import static br.com.trajy.delivery.infra.identity.core.common.exception.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.user.domain.model.enums.UserStatus.ACTIVE;

public final class UserFactory {

    private UserFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static UserAggregate createUser(String email) {
        final UserAggregate model = new UserAggregate();
        model.setEmail(email);
        model.setStatus(ACTIVE);
        return model;
    }

}
