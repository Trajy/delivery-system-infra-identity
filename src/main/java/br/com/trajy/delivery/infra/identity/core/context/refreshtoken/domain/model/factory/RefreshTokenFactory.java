package br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.factory;

import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.aggregate.RefreshTokenAggregate;
import br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.EncryptionType;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.CreateUserWithPasswordCredentialWrapperInput;
import br.com.trajy.delivery.infra.identity.core.feature.password.model.wrapper.input.LoginWithPasswordCredentialWrapperInput;

import static br.com.trajy.delivery.infra.identity.core.common.exception.type.UnsupportedInstantiationException.utilityClassUnsupportedInstantiationException;
import static br.com.trajy.delivery.infra.identity.core.context.refreshtoken.domain.model.enums.RefreshTokenStatusType.ACTIVE;

public final class RefreshTokenFactory {

    private RefreshTokenFactory() {
        utilityClassUnsupportedInstantiationException();
    }

    public static RefreshTokenAggregate createRefreshToken(LoginWithPasswordCredentialWrapperInput input) {
        final RefreshTokenAggregate aggregate = new RefreshTokenAggregate();
        aggregate.setStatus(ACTIVE);
        aggregate.setEncryptionType(input.encryptionType());
        return aggregate;
    }

}
