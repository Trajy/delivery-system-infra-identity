package br.com.trajy.delivery.infra.identity.core.feature.user.domain.modelfactory;

import br.com.trajy.delivery.infra.identity.core.feature.user.domain.model.User;

import static br.com.trajy.delivery.infra.identity.core.common.exception.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.feature.user.domain.enums.UserStatus.ACTIVE;

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
